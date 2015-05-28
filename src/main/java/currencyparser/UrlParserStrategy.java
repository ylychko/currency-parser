package currencyparser;

import currencyparser.entity.Rate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import currencyparser.entity.Currency;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eyevlyc on 12/17/2014.
 */
public class UrlParserStrategy implements ParserStrategy {
    private String url;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public List<Currency> parse() {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.select(".content > table:nth-child(6) > tbody:nth-child(1) > tr");
        List<Currency> list = new ArrayList<Currency>();

        for (int i = 1; i < elements.size(); i++) {
            Element e = elements.get(i);

            Currency c = new Currency();
            c.setDcode(Integer.parseInt(e.children().get(0).text()));
            c.setLcode(e.children().get(1).text().trim());
            c.setName(e.children().get(3).text().trim());
            Rate rate = new Rate();

            rate.setUnits(Integer.parseInt(e.children().get(2).text()));
            rate.setRate(Double.parseDouble(e.children().get(4).text()));
            rate.setDate(new Date(System.currentTimeMillis()));
            rate.setCurrency(c);
            // create rates
            Set<Rate> set = new HashSet<>();
            set.add(rate);
            c.setRates(set);
            System.out.println(c);
            list.add(c);

        }
        return list;
    }

    @Override
    public String toString() {
        return "UrlParserStrategy{" +
                "url='" + url + '\'' +
                '}';
    }
}
