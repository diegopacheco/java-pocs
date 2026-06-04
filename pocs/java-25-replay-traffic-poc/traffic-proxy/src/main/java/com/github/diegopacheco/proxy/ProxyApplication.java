package com.github.diegopacheco.proxy;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.Executors;

public final class ProxyApplication {

    public static void main(String[] args) throws IOException {
        int proxyPort = envInt("PROXY_PORT", 8000);
        int controlPort = envInt("CONTROL_PORT", 8001);
        URI backend = URI.create(env("BACKEND_URL", "http://127.0.0.1:8080"));
        Path logPath = Path.of(env("TRAFFIC_LOG", "traffic.log"));
        int maxBody = envInt("MAX_BODY", 4096);

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        TrafficLog log = new TrafficLog(logPath);
        Stats stats = new Stats();
        URI proxyUri = URI.create("http://127.0.0.1:" + proxyPort);
        TrafficGenerator generator = new TrafficGenerator(proxyUri, client);
        Replayer replayer = new Replayer(backend, client, log);

        HttpServer proxyServer = HttpServer.create(new InetSocketAddress(proxyPort), 0);
        proxyServer.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        proxyServer.createContext("/", new ProxyHandler(backend, client, log, stats, maxBody));

        HttpServer controlServer = HttpServer.create(new InetSocketAddress(controlPort), 0);
        controlServer.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        new ControlApi(log, stats, generator, replayer, backend).register(controlServer);

        proxyServer.start();
        controlServer.start();

        System.out.println("traffic-proxy listening on :" + proxyPort + " forwarding to " + backend);
        System.out.println("control api listening on :" + controlPort);
        System.out.println("capturing traffic into " + logPath.toAbsolutePath());
    }

    private static String env(String name, String fallback) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? fallback : value;
    }

    private static int envInt(String name, int fallback) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return Integer.parseInt(value.trim());
    }
}
