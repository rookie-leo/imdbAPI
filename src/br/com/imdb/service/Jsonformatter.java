package br.com.imdb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jsonformatter {

    public static void jsonParse(String response) {
        String json = response.substring(response.indexOf("[")+1, response.indexOf("]"));
        List<String> listaDeFilmes = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{([^\\}]+?)\\}");
        Matcher matcher = pattern.matcher(json);

        while (matcher.find()) {
            String result = matcher.group(1);
            listaDeFilmes.add(result);
        }

        Pattern.compile("\"([^\"]*)\"");

        listaDeFilmes.stream().forEach(System.out::println);

    }

}
