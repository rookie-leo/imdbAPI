package br.com.imdb.gateway.model;

import java.util.Objects;

public class Movie {

    private String title;
    private String urlImage;
    private Double rating;
    private int year;

    public Movie(String title, String urlImage, Double rating, int year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
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
