package com.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledIf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.bookstore.model.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@EnabledIf("dynamoAvailable")
class BookApiIntegrationTest {

    @Value("${local.server.port}")
    private int port;

    private RestClient client;

    static boolean dynamoAvailable() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8000), 500);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @BeforeEach
    void setUp() {
        client = RestClient.builder()
                .baseUrl("http://localhost:" + port)
                .defaultStatusHandler(status -> true, (request, response) -> {
                })
                .build();
    }

    private String token() {
        ResponseEntity<Map> response = client.post().uri("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("username", "admin", "password", "admin"))
                .retrieve().toEntity(Map.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        return (String) response.getBody().get("token");
    }

    @Test
    @Order(1)
    void protectedEndpointRejectsMissingToken() {
        ResponseEntity<String> response = client.get().uri("/api/books").retrieve().toEntity(String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode(),
                "book endpoints must require a JWT so the catalog is not open to anonymous callers");
    }

    @Test
    @Order(2)
    void fullBookLifecycleAndAtomicBatchTransaction() {
        String jwt = token();

        Book a = create(jwt, "Clean Code", "Martin", 400);
        Book b = create(jwt, "Refactoring", "Fowler", 448);
        assertEquals(0, a.pagesRead(), "a freshly created book starts at zero pages read");

        Book fetched = client.get().uri("/api/books/" + a.id()).headers(h -> h.setBearerAuth(jwt))
                .retrieve().toEntity(Book.class).getBody();
        assertEquals(a.id(), fetched.id());

        Book patched = client.patch().uri("/api/books/" + a.id() + "/pages").headers(h -> h.setBearerAuth(jwt))
                .contentType(MediaType.APPLICATION_JSON).body(Map.of("pagesRead", 120))
                .retrieve().toEntity(Book.class).getBody();
        assertEquals(120, patched.pagesRead(), "tracking read progress must persist the new page count");

        Map<String, Object> batch = Map.of("updates", List.of(
                Map.of("id", a.id(), "pagesRead", 200),
                Map.of("id", b.id(), "pagesRead", 100)));
        ResponseEntity<Book[]> ok = client.post().uri("/api/books/batch-pages").headers(h -> h.setBearerAuth(jwt))
                .contentType(MediaType.APPLICATION_JSON).body(batch)
                .retrieve().toEntity(Book[].class);
        assertEquals(HttpStatus.OK, ok.getStatusCode());

        Map<String, Object> badBatch = Map.of("updates", List.of(
                Map.of("id", a.id(), "pagesRead", 333),
                Map.of("id", b.id(), "pagesRead", 99999)));
        ResponseEntity<String> rolledBack = client.post().uri("/api/books/batch-pages").headers(h -> h.setBearerAuth(jwt))
                .contentType(MediaType.APPLICATION_JSON).body(badBatch)
                .retrieve().toEntity(String.class);
        assertEquals(HttpStatus.CONFLICT, rolledBack.getStatusCode(),
                "a batch that violates a condition on any book must fail the whole transaction");

        Book afterRollback = client.get().uri("/api/books/" + a.id()).headers(h -> h.setBearerAuth(jwt))
                .retrieve().toEntity(Book.class).getBody();
        assertEquals(200, afterRollback.pagesRead(),
                "because the transaction rolled back, book A must keep its pre-transaction value of 200, not 333");
    }

    @Test
    @Order(3)
    void listBooksIsPaginatedAndDefaultsToPageZeroSizeTwo() {
        String jwt = token();
        create(jwt, "Zzz Padding One", "Filler", 100);
        create(jwt, "Zzz Padding Two", "Filler", 100);
        create(jwt, "Zzz Padding Three", "Filler", 100);

        Map defaults = client.get().uri("/api/books").headers(h -> h.setBearerAuth(jwt))
                .retrieve().toEntity(Map.class).getBody();
        assertEquals(0, ((Number) defaults.get("page")).intValue(), "page must default to 0");
        assertEquals(2, ((Number) defaults.get("size")).intValue(), "size must default to 2");
        assertEquals(2, ((List<?>) defaults.get("content")).size(),
                "a full default page must contain exactly 2 books so the client can page");
        assertTrue(((Number) defaults.get("total")).intValue() >= 3, "total counts every book, not just the page");

        Map second = client.get().uri("/api/books?page=1&size=3").headers(h -> h.setBearerAuth(jwt))
                .retrieve().toEntity(Map.class).getBody();
        assertEquals(1, ((Number) second.get("page")).intValue());
        assertEquals(3, ((Number) second.get("size")).intValue());
        assertTrue(((List<?>) second.get("content")).size() <= 3);
    }

    @Test
    @Order(4)
    void sqlConsoleRequiresJwtAndRunsPartiqlOverJdbc() {
        ResponseEntity<String> unauthorized = client.post().uri("/api/sql/execute")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("sql", "SELECT id FROM \"Books\""))
                .retrieve().toEntity(String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, unauthorized.getStatusCode(),
                "the SQL console is now behind JWT, so an anonymous statement must be rejected");

        String jwt = token();
        ResponseEntity<Map> response = client.post().uri("/api/sql/execute").headers(h -> h.setBearerAuth(jwt))
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("sql", "SELECT id, title FROM \"Books\""))
                .retrieve().toEntity(Map.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(((Number) response.getBody().get("rowCount")).intValue() >= 0,
                "the SQL console must return a structured result set from DynamoDB");
        assertNotNull(response.getBody().get("columns"));
    }

    @Test
    @Order(5)
    void schemaEndpointListsBooksTableWithFields() {
        String jwt = token();
        ResponseEntity<List> response = client.get().uri("/api/sql/schema").headers(h -> h.setBearerAuth(jwt))
                .retrieve().toEntity(List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        boolean hasBooks = response.getBody().stream()
                .anyMatch(t -> "Books".equals(((Map<?, ?>) t).get("name")));
        assertTrue(hasBooks, "the schema browser must discover the Books table so the console can list its fields");
    }

    private Book create(String jwt, String title, String author, int totalPages) {
        ResponseEntity<Book> response = client.post().uri("/api/books").headers(h -> h.setBearerAuth(jwt))
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("title", title, "author", author, "totalPages", totalPages))
                .retrieve().toEntity(Book.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        return response.getBody();
    }
}
