package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;
import br.com.imdb.service.Jsonformatter;

import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;

public class ImdbApplication {

    public static void main(String[] args) {
        String apiKey = Arrays.stream(args).findFirst().get();
        ImdbClient imdb = new ImdbClient();

        var client = HttpClient.newHttpClient();
        var response = imdb.findTop250Movies(apiKey, client).body();

        String[] moviesArray = Jsonformatter.jsonParse(response);
        List<String> titleList = Jsonformatter.titleParse(moviesArray);
        List<String> urlImagesList = Jsonformatter.urlImageParse(moviesArray);

        titleList.forEach(System.out::println);
        urlImagesList.forEach(System.out::println);
    }



}
