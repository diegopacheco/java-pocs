import io.specto.hoverfly.junit.core.Hoverfly;
import io.specto.hoverfly.junit.core.SimulationSource;
import io.specto.hoverfly.junit.core.HoverflyMode;
import static io.specto.hoverfly.junit.core.HoverflyConfig.configs;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.*;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.HttpHost;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int hoverflyAdminPort = Integer.parseInt(System.getenv().getOrDefault("HOVERFLY_ADMIN_PORT", "8888"));
        int hoverflyProxyPort = Integer.parseInt(System.getenv().getOrDefault("HOVERFLY_PROXY_PORT", "8500"));

        Hoverfly hoverfly = new Hoverfly(configs()
                .adminPort(hoverflyAdminPort)
                .proxyPort(hoverflyProxyPort), HoverflyMode.SIMULATE);
        hoverfly.start();

        hoverfly.simulate(SimulationSource.dsl(
                service("http://api.test.com")
                        .get("/users/1")
                        .willReturn(success()
                                .body("{\"id\":1,\"name\":\"John Doe\",\"email\":\"john@test.com\"}")
                                .header("Content-Type", "application/json"))
                        .get("/users/2")
                        .willReturn(success()
                                .body("{\"id\":2,\"name\":\"Jane Smith\",\"email\":\"jane@test.com\"}")
                                .header("Content-Type", "application/json"))
                        .post("/users")
                        .willReturn(created()
                                .body("{\"id\":3,\"name\":\"New User\",\"email\":\"newuser@test.com\"}")
                                .header("Content-Type", "application/json"))
        ));

        System.out.println("Hoverfly started in simulation mode");
        System.out.println("Admin UI: http://localhost:" + hoverflyAdminPort);
        System.out.println("Proxy Port: " + hoverflyProxyPort);
        System.out.println("\nSimulated endpoints (use proxy):");
        System.out.println("  GET  http://api.test.com/users/1 (via proxy localhost:" + hoverflyProxyPort + ")");
        System.out.println("  GET  http://api.test.com/users/2 (via proxy localhost:" + hoverflyProxyPort + ")");
        System.out.println("  POST http://api.test.com/users (via proxy localhost:" + hoverflyProxyPort + ")");

        testSimulationWithProxy("localhost", hoverflyProxyPort);

        System.out.println("\nHoverfly is running. Press Ctrl+C to stop...");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nStopping Hoverfly...");
            hoverfly.close();
        }));

        Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println("Application interrupted");
            }
        }
    }

    private static void testSimulationWithProxy(String proxyHost, int proxyPort) {
        System.out.println("\nTesting simulation with proxy:");
        CloseableHttpClient client = null;
        try {
            client = HttpClients.custom()
                .setProxy(new HttpHost(proxyHost, proxyPort))
                .build();
            HttpGet request = new HttpGet("http://api.test.com/users/1");
            try (CloseableHttpResponse response = client.execute(request)) {
                String body = EntityUtils.toString(response.getEntity());
                System.out.println("Response: " + body);
            }
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
