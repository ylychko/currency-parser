package currencyparser;

import currencyparser.dao.CurrencyDAO;
import currencyparser.entity.Currency;

import java.util.List;

/**
 * Created by eyevlyc on 12/17/2014.
 */
public class Parser {
    private ParserStrategy parserStrategy;
    private CurrencyDAO currencyDAO;

    public Parser(ParserStrategy strategy) {
        this.parserStrategy = strategy;
        System.out.println("Parser: instance created");
    }


    public void run() {
        List<Currency> list = parserStrategy.parse();
        for(Currency c : list){
            currencyDAO.add(c);
        }
    }

    public ParserStrategy getParserStrategy() {
        return parserStrategy;
    }

    public CurrencyDAO getCurrencyDAO() {
        return currencyDAO;
    }

    public void setCurrencyDAO(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Override
    public String toString() {
        return "Parser{" +
                "parserStrategy=" + parserStrategy +
                ", currencyDAO=" + currencyDAO +
                '}';
    }
}
