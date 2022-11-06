package br.com.imdb.gateway.model;

import java.util.Objects;

public class Movie implements Content {

    private String title;
    private String urlImage;
    private Double rating;
    private Integer year;

    public Movie(String title, String urlImage, Double rating, int year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String urlImage() {
        return urlImage;
    }

    @Override
    public String rating() {
        return rating.toString();
    }

    @Override
    public String year() {
        return year.toString();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && Objects.equals(title, movie.title) && Objects.equals(urlImage, movie.urlImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, urlImage, rating, year);
    }
}
