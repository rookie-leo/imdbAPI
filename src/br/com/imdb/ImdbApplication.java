package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;
import br.com.imdb.gateway.model.Movie;
import br.com.imdb.service.HTMLGenerator;
import br.com.imdb.service.Jsonformatter;
import br.com.imdb.gateway.model.builder.MovieBuilder;

import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.util.ArrayList;
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
        List<String> rating = Jsonformatter.rantingParse(moviesArray);
        List<String> year = Jsonformatter.yearParse(moviesArray);
        List<Movie> movies = new ArrayList<>();

        moviesMaker(moviesArray, titleList, urlImagesList, rating, year, movies);

        HTMLGenerator htmlGenerator = new HTMLGenerator(new PrintWriter(System.out));

        htmlGenerator.generate(movies);
    }

    private static void moviesMaker(String[] moviesArray, List<String> titleList, List<String> urlImagesList, List<String> rating, List<String> year, List<Movie> movies) {
        for (int i = 0; i < moviesArray.length; i++) {
            Movie movie = new MovieBuilder()
                    .buildTitle(titleList.get(i))
                    .buildUrlImage(urlImagesList.get(i))
                    .buildRating(rating.get(i))
                    .buildYear(year.get(i))
                    .build();
            movies.add(movie);
        }
    }

}
