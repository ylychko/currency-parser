package currencyparser;

import currencyparser.entity.Currency;

import java.util.List;

/**
 * Created by eyevlyc on 12/17/2014.
 */
public interface ParserStrategy {
    void setUrl(String url);
    String getUrl();
    List<Currency> parse();
}
