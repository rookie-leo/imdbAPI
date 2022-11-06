package br.com.imdb.service;

import br.com.imdb.gateway.model.Content;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {//TODO - gerar um arquivo HTML

    private PrintWriter writer;

    public HTMLGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    public void generate(List<? extends Content> movies) {
        writer.write(headerGenerator());
        for (Content content : movies) {
            String body = "<body>" + divTemplateGenerator(content);
            writer.write(body);
        }
        writer.write("</body> </html>");
        writer.close();
    }

    private static String divTemplateGenerator(Content content) {
        String divTemplate = "<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">" +
                "<h4 class=\"card-header\">" + content.title() + "</h4>" +
                "<div class=\"card-body\">" +
                "<img class=\"card-img\" src=\"" + content.urlImage() + "\" alt=\"%s\">" +
                "<p class=\"card-text mt-2\">Nota:" + content.rating() + "- Ano: " + content.year() + "</p>" +
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
