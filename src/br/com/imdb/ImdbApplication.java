package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;
import br.com.imdb.gateway.model.Movie;
import br.com.imdb.service.HTMLGenerator;
import br.com.imdb.service.JsonBuilder;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class ImdbApplication {

    public static void main(String[] args) {
        var response = new ImdbClient().findTop250Movies(Arrays.stream(args).findFirst().get()).body();

        List<Movie> movies = new JsonBuilder(response).build();

        new HTMLGenerator(new PrintWriter(System.out)).generate(movies);
    }
}
