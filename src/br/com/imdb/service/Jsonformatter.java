package br.com.imdb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jsonformatter {

    public static String[] jsonParse(String response) {
        Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(response);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("no match in " + response);
        }

        String[] moviesArray = matcher.group(1).split("\\},\\{");
        moviesArray[0] = moviesArray[0].substring(1);
        int last = moviesArray.length - 1;
        String lastString = moviesArray[last];
        moviesArray[last] = lastString.substring(0, lastString.length() - 1);

        return moviesArray;
    }

    public static List<String> titleParse(String[] moviesArray) {
        return parseAtribute(moviesArray, 3);
    }

    public static List<String> urlImageParse(String[] moviesArray) {
        return parseAtribute(moviesArray, 5);
    }

    private static List<String> parseAtribute(String[] moviesArray, int i) {
        return Stream.of(moviesArray)
                .map(atribute -> atribute.split("\",\"")[i])
                .map(atribute -> atribute.split(":\"")[1])
                .map(atribute -> atribute.replaceAll("\"",""))
                .collect(Collectors.toList());
    }



}
