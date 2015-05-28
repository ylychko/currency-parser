package currencyparser.dao.it;

import currencyparser.dao.CurrencyDAO;
import currencyparser.entity.Currency;
import currencyparser.entity.Rate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.sql.Date;
import java.util.HashSet;

/**
 * Created by eyevlyc on 1/14/2015.
 */

// exists in super class
// @RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "classpath:context.xml")
@TransactionConfiguration
public class CurrencyDaoTestBase extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected CurrencyDAO currencyDAO;

    @Autowired
    protected SessionFactory sessionFactory;

    protected Currency createCurrency(String lcode, int dcode) {
        Currency currency = new Currency();
        currency.setName(lcode + "-name");
        currency.setLcode(lcode);
        currency.setDcode(dcode);
        currency.setRates(new HashSet<Rate>());
        return currency;
    }

    protected Rate createRate(double value, int units, Date date, Currency c) {
        Rate rate = new Rate();
        rate.setDate(date);
        rate.setUnits(units);
        rate.setRate(value);
        rate.setCurrency(c);
        return rate;
    }

    protected Session session() {
        return sessionFactory.getCurrentSession();
    }
}
