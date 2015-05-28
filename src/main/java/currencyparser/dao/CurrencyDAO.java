package currencyparser.dao;

import currencyparser.entity.Currency;
import currencyparser.entity.Rate;

import java.sql.Date;
import java.util.List;

/**
 * Created by eyevlyc on 1/12/2015.
 */
public interface CurrencyDAO {
    void add(Currency currency);
    List<Rate> list(Date date);
    List<Currency> list();
}
