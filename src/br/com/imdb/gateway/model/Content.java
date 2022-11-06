package br.com.imdb.gateway.model;

public interface Content extends Comparable<Content> {

    String title();
    String urlImage();
    String rating();
    String year();

}
