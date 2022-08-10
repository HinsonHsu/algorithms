package utils;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyHttpServer {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/", httpExchange -> {
                String response = "{\"code\":\"200\"}";
                httpExchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = httpExchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            });
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
