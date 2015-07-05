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
        System.out.println("Parser: everything is OK");
        System.out.println("AAA");
        System.out.println("Changes!");
        System.out.println("Changes4!");
        System.out.println("Changes3!");
        System.out.println("Changes2!");
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
