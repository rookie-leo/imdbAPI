package br.com.imdb.gateway.model.builder;

import br.com.imdb.gateway.model.Content;
import br.com.imdb.gateway.model.Movie;

public class ContentBuilder {

    private String title;
    private String urlImage;
    private Double rating;
    private int year;

    public ContentBuilder(){}

    public ContentBuilder buildTitle(String title) {
       this.title = title;
       return this;
    }


    public ContentBuilder buildUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }


    public ContentBuilder buildRating(String rating) {
        this.rating = Double.parseDouble(rating);
        return this;
    }


    public ContentBuilder buildYear(String year) {
        this.year = Integer.parseInt(year);
        return this;
    }

    public Content build() {
        return new Movie(title, urlImage, rating, year);
    }
}
