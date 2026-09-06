package com.github.diegopacheco.sandboxspring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LedgerEndpointTest {

    @LocalServerPort
    private int port;

    private final HttpClient client = HttpClient.newHttpClient();

    @Test
    @DisplayName("amounts cross the wire as strings, so no client parses them into a double")
    void amountsAreSerializedAsStrings() throws Exception {
        HttpResponse<String> response = post("/ledger/transfers", """
                {"id":"http-1","from":"alice","to":"bob","amount":"25.50","currency":"USD","description":"rent"}""");

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"amount\":\"25.50\""), response.body());
        assertTrue(response.body().contains("\"minorUnits\":2550"), response.body());
        assertTrue(response.body().contains("\"amount\":\"-25.50\""), response.body());
    }

    @Test
    @DisplayName("every entry returned by the API carries a zero residual")
    void postedEntriesBalance() throws Exception {
        HttpResponse<String> response = post("/ledger/sales", """
                {"id":"http-2","customer":"customer","revenue":"revenue","taxAccount":"tax-payable",\
                "net":"19.99","currency":"USD","taxRate":"0.0825","rounding":"HALF_UP"}""");

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"residual\":{\"amount\":\"0.00\""), response.body());
        assertTrue(response.body().contains("\"amount\":\"1.65\""), response.body());
        assertTrue(response.body().contains("\"amount\":\"-21.64\""), response.body());
    }

    @Test
    @DisplayName("a distribution over the wire still hands out the remainder cent")
    void distributionKeepsEveryCentOverHttp() throws Exception {
        HttpResponse<String> response = post("/ledger/distributions", """
                {"id":"http-3","from":"pool","recipients":["alice","bob","carol"],"total":"10.00","currency":"USD"}""");

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"amount\":\"3.34\""), response.body());
        assertTrue(response.body().contains("\"amount\":\"3.33\""), response.body());
    }

    @Test
    @DisplayName("a sub-cent amount is rejected at the edge instead of being rounded into the ledger")
    void subCentAmountIsRejected() throws Exception {
        HttpResponse<String> response = post("/ledger/transfers", """
                {"id":"http-4","from":"alice","to":"bob","amount":"1.005","currency":"USD","description":"sub cent"}""");

        assertEquals(400, response.statusCode());
    }

    @Test
    @DisplayName("a rate without a rounding mode is rejected instead of defaulting to one")
    void missingRoundingModeIsRejected() throws Exception {
        HttpResponse<String> response = post("/ledger/sales", """
                {"id":"http-5","customer":"customer","revenue":"revenue","taxAccount":"tax-payable",\
                "net":"19.99","currency":"USD","taxRate":"0.0825"}""");

        assertEquals(400, response.statusCode());
    }

    @Test
    @DisplayName("a replayed request cannot post the same movement twice")
    void replayedEntryIsRejected() throws Exception {
        String body = """
                {"id":"http-6","from":"payer-6","to":"payee-6","amount":"0.07","currency":"USD","description":"payout"}""";

        assertEquals(200, post("/ledger/transfers", body).statusCode());
        assertEquals(409, post("/ledger/transfers", body).statusCode());

        HttpResponse<String> balance = get("/ledger/accounts/payee-6/balance?currency=USD");
        assertTrue(balance.body().contains("\"amount\":\"0.07\""), balance.body());
    }

    private HttpResponse<String> post(String path, String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(uri(path))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private HttpResponse<String> get(String path) throws IOException, InterruptedException {
        return client.send(HttpRequest.newBuilder(uri(path)).GET().build(), HttpResponse.BodyHandlers.ofString());
    }

    private URI uri(String path) {
        return URI.create("http://localhost:" + port + path);
    }
}
