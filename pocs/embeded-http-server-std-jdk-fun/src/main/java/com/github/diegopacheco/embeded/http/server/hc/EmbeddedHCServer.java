package com.github.diegopacheco.embeded.http.server.hc;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class EmbeddedHCServer {

    private static final int PORT = 8888;
    private static HttpServer server;

    public static void start(){
        try{
            server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/hc", new HCHandler());
            server.setExecutor(null);

            System.out.println("Embedded Http Server running on http://localhost:"+PORT);
            server.start();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    static class HCHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "200";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void stop(){
        server.stop(0);
    }

    public static URL getServerHCURL(){
        try {
            return new URL("http://localhost:"+PORT+"/hc");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
