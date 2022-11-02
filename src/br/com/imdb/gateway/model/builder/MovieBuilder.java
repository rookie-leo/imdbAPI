package br.com.imdb.gateway.model.builder;

import br.com.imdb.gateway.model.Movie;

public class MovieBuilder /*implements Builder*/ {

    private String title;
    private String urlImage;
    private Double rating;
    private int year;

    public MovieBuilder(){}

    public MovieBuilder buildTitle(String title) {
       this.title = title;
       return this;
    }


    public MovieBuilder buildUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }


    public MovieBuilder buildRating(String rating) {
        this.rating = Double.parseDouble(rating);
        return this;
    }


    public MovieBuilder buildYear(String year) {
        this.year = Integer.parseInt(year);
        return this;
    }

    public Movie build() {
        return new Movie(title, urlImage, rating, year);
    }
}
