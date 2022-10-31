package br.com.imdb.gateway.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbClient {
    private HttpRequest request;
    private HttpResponse<String> response;

    public HttpResponse<String> findTop250Movies(String apiKey, HttpClient client) {
            String uri = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;

            request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();

        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response;
    }
}
