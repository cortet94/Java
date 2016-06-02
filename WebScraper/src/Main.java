import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.SocketTimeoutException;


/**
 * Created by Corey on 6/1/16.
 */
public class Main {
    public static void main(String[] args) {
        boolean found = false;
        while (!found) {
            try {
                Document doc = Jsoup.parseBodyFragment(Jsoup.connect("http://reddit.com").get().toString());
                Element body = doc.body();
                Elements siteTable = body.getElementsByClass("title");
                for (Element entry : siteTable) {
                    Elements title = entry.getElementsByTag("a");
                    for (Element name : title) {
                        System.out.println(name.text() + "\n");

                    }

                }

                found = true;

            } catch (Exception e) {
                System.out.println("Failed, trying again");
            }
        }

        }
}
