package br.com.imdb.service;

import br.com.imdb.gateway.model.Content;
import br.com.imdb.gateway.model.JsonParser;
import br.com.imdb.gateway.model.builder.ContentBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jsonformatter implements JsonParser {

    private String response;

    public Jsonformatter(String response) {
        this.response = response;
    }

    @Override
    public List<? extends Content> parse() {
        String[] contentArray = jsonParse(response);
        List<String> titleList = titleParse(contentArray);
        List<String> urlImagesList = urlImageParse(contentArray);
        List<String> rating = rantingParse(contentArray);
        List<String> year = yearParse(contentArray);
        List<? extends Content> contents = contentsMaker(contentArray, titleList, urlImagesList, rating, year);

        return contents;
    }

    public static String[] jsonParse(String response) {
        Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(response);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("no match in " + response);
        }

        String[] contentArray = matcher.group(1).split("\\},\\{");
        contentArray[0] = contentArray[0].substring(1);
        int last = contentArray.length - 1;
        String lastString = contentArray[last];
        contentArray[last] = lastString.substring(0, lastString.length() - 1);

        return contentArray;
    }

    public static List<String> titleParse(String[] contentArray) {
        return parseAtribute(contentArray, 3);
    }

    public static List<String> urlImageParse(String[] contentArray) {
        return parseAtribute(contentArray, 5);
    }

    public static List<String> rantingParse(String[] contentArray) {
        return parseAtribute(contentArray, 7);
    }

    public static List<String> yearParse(String[] contentArray) {
        return parseAtribute(contentArray, 4);//5
    }

    private static List<String> parseAtribute(String[] contentArray, int i) {
        return Stream.of(contentArray)
                .map(atribute -> atribute.split("\",\"")[i])
                .map(atribute -> atribute.split(":\"")[1])
                .map(atribute -> atribute.replaceAll("\"", ""))
                .collect(Collectors.toList());
    }

    private static List<? extends Content> contentsMaker(String[] contentArray, List<String> titleList, List<String> urlImagesList, List<String> rating, List<String> year) {
        List<Content> contents = new ArrayList<>();
        for (int i = 0; i < contentArray.length; i++) {
            Content content = new ContentBuilder()
                    .buildTitle(titleList.get(i))
                    .buildUrlImage(urlImagesList.get(i))
                    .buildRating(rating.get(i))
                    .buildYear(year.get(i))
                    .build();
            contents.add(content);
        }

        return contents;
    }

}
