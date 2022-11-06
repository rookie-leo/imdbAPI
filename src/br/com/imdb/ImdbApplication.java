package br.com.imdb;

import br.com.imdb.gateway.client.ImdbClient;
import br.com.imdb.gateway.model.Content;
import br.com.imdb.service.HTMLGenerator;
import br.com.imdb.service.Jsonformatter;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class ImdbApplication {

    public static void main(String[] args) {
        var response = new ImdbClient().findTop250Movies(Arrays.stream(args).findFirst().get()).body();
//TODO - tentar um response com a API da Marvel

        List<? extends Content> movies = new Jsonformatter(response).parse();

        new HTMLGenerator(new PrintWriter(System.out)).generate(movies);
    }
}
