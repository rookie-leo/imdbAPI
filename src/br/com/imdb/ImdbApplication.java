package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;
import br.com.imdb.service.Jsonformatter;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImdbApplication {

    public static void main(String[] args) {
        String apiKey = Arrays.stream(args).findFirst().get();
        ImdbClient imdb = new ImdbClient();

        var client = HttpClient.newHttpClient();
        var response = imdb.findTop250Movies(apiKey, client).body();

        Jsonformatter.jsonParse(response);
    }



}
