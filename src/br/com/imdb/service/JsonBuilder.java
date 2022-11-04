package br.com.imdb.service;

import br.com.imdb.gateway.model.Movie;
import br.com.imdb.gateway.model.builder.MovieBuilder;

import java.util.ArrayList;
import java.util.List;

public class JsonBuilder {
    private String response;

    public JsonBuilder(String response) {
        this.response = response;
    }

    public List<Movie> build() {
        String[] moviesArray = Jsonformatter.jsonParse(response);
        List<String> titleList = Jsonformatter.titleParse(moviesArray);
        List<String> urlImagesList = Jsonformatter.urlImageParse(moviesArray);
        List<String> rating = Jsonformatter.rantingParse(moviesArray);
        List<String> year = Jsonformatter.yearParse(moviesArray);
        List<Movie> movies = moviesMaker(moviesArray, titleList, urlImagesList, rating, year);

        return movies;
    }

    private static List<Movie> moviesMaker(String[] moviesArray, List<String> titleList, List<String> urlImagesList, List<String> rating, List<String> year) {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < moviesArray.length; i++) {
            Movie movie = new MovieBuilder()
                    .buildTitle(titleList.get(i))
                    .buildUrlImage(urlImagesList.get(i))
                    .buildRating(rating.get(i))
                    .buildYear(year.get(i))
                    .build();
            movies.add(movie);
        }

        return movies;
    }
}
