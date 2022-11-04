package br.com.imdb.service;

import br.com.imdb.gateway.model.Movie;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    private PrintWriter writer;

    public HTMLGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    public void generate(List<Movie> movies) {
        writer.write(headerGenerator());
        for (Movie movie : movies) {
            String body = "<body>" + divTemplateGenerator(movie);
            writer.write(body);
        }
        writer.write("</body> </html>");
        writer.close();
    }

    private static String divTemplateGenerator(Movie movie) {
        String divTemplate = "<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">" +
                "<h4 class=\"card-header\">" + movie.getTitle() + "</h4>" +
                "<div class=\"card-body\">" +
                "<img class=\"card-img\" src=\"" + movie.getUrlImage() + "\" alt=\"%s\">" +
                "<p class=\"card-text mt-2\">Nota:" + movie.getRating() + "- Ano: " + movie.getYear() + "</p>" +
                "</div>" +
                "</div>";

        return divTemplate;
    }

    private static String headerGenerator() {
        String header =
                """
                        <!DOCTYPE html>
                                <html>
                                <head>
                                   	<meta charset=\"utf-8\">
                                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                                    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
                                </head>
                        """;

        return header;
    }
}
