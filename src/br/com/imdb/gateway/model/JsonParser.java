package br.com.imdb.gateway.model;

import java.util.List;

public interface JsonParser {

    public List<? extends Content> parse();

}
