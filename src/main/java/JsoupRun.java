import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupRun {
    public static void main(String[] args) throws IOException {
        List<String> titlesList = new ArrayList<>();
        Document document = Jsoup.connect("https://www.imdb.com/chart/top")
                .timeout(6000).get();
        // timeout of 6000 is approx. 1 minute
        Elements body = document.select("tbody");
        int count = 1;
        for (Element e: body.select("tr")) {
            String title = e.select("td img").attr("alt");
            titlesList.add(count + ". " + title);
            count++;
        }
        titlesList.forEach(System.out::println);
    }
}
