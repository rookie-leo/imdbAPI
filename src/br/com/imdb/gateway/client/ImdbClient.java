package br.com.imdb.gateway.client;

import java.io.FileNotFoundException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.*;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.file.Paths;

public class ImdbClient {

    private String apiKey = "";//TODO - tentar receber a apiKey como argumento ao rodar o código Java
    private String uri = "https://imdb-api.com/en/API/Top250Movies/" + apiKey + "https://imdb-api.com/en/API/Top250Movies/";
    private HttpClient client;
    private HttpRequest request;

    public ImdbClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public void getClient() {
         client = HttpClient.newBuilder()
                 .version(Version.HTTP_2)
                 .followRedirects(Redirect.NORMAL)
                 .proxy(ProxySelector.of(new InetSocketAddress("www-proxy.com", 8080)))
                 .authenticator(Authenticator.getDefault())
                 .build();
     }

    public void requestConstructor() {
        try {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofFile(Paths.get("file.json")))
                    .build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado: " + e);
        }
    }


}
