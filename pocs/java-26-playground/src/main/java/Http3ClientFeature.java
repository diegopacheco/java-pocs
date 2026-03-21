/**
 * JEP 517: HTTP/3 for the HTTP Client API
 * Adds HTTP/3 protocol support to Java's HTTP client API with fallback to HTTP/2 and HTTP/1.1.
 * @see <a href="https://openjdk.org/jeps/517">JEP 517</a>
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http3ClientFeature {
    public static void run() {
        try {
            var client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_3)
                    .build();

            var request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                    .version(HttpClient.Version.HTTP_3)
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("HTTP/3 Response Status: " + response.statusCode());
            System.out.println("HTTP/3 Protocol Version: " + response.version());
        } catch (Exception e) {
            System.out.println("HTTP/3 Feature: " + e.getMessage());
        }
    }
}
