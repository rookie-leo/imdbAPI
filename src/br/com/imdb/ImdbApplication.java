package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;

import java.util.Arrays;

public class ImdbApplication {

    public static void main(String[] args) {

        String apiKey = Arrays.stream(args).findFirst().get();

        ImdbClient imdb = new ImdbClient(apiKey);

        System.out.println(apiKey);

    }

}
