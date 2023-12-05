package com.sao.htmlstring;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.htmlstring
 * @date 27.Kas.2023
 * <p>
 * @description:
 */
public class HtmlString {
    public static void main(String[] args) {
        String html = "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"tr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>YDS Dersleri</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>YDS Dersleri</h1>\n" +
                "\t<h2>Word Up Kelime Dersleri</h2>\n" +
                "\t<h3>StartUp</h3>\n" +
                "\t<h4>Adjectives</h4>\n" +
                "    <ul>\n" +
                "\n" +
                "    </ul>\n" +
                "\n" +
                "    <p>Ayrıca, iç sayfalarınıza da link verebilirsiniz:</p>\n" +
                "\n" +
                "    <ul>\n" +
                "        <li><a href=\"sayfa1.html\">Sayfa 1</a></li>\n" +
                "        <li><a href=\"sayfa2.html\">Sayfa 2</a></li>\n" +
                "        <li><a href=\"sayfa3.html\">Sayfa 3</a></li>\n" +
                "    </ul>\n" +
                "</body>\n" +
                "</html>";

        Document document = Jsoup.parse(html);
        Elements elements = document.select("*");

        StringBuilder plainTextBuilder = new StringBuilder();

        for (Element element : elements) {
            if (plainTextBuilder.length() > 0) {
                plainTextBuilder.append("\n");
            }
            plainTextBuilder.append(element.ownText());
        }

        System.out.println(plainTextBuilder.toString());
    }
}
