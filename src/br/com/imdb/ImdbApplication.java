package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;

import java.net.http.HttpClient;
import java.util.Arrays;

public class ImdbApplication {

    public static void main(String[] args) {
        String apiKey = Arrays.stream(args).findFirst().get();
        ImdbClient imdb = new ImdbClient();

        var client = HttpClient.newHttpClient();
        var response = imdb.findTop250Movies(apiKey, client);

        System.out.println(response.statusCode());
        System.out.println(response.body());

    }

}
