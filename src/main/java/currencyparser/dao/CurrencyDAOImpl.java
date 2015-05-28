package currencyparser.dao;

import currencyparser.entity.Currency;
import currencyparser.entity.Rate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by eyevlyc on 1/12/2015.
 */

public class CurrencyDAOImpl implements CurrencyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public List<Rate> list(Date date) {
        List<Rate> out = session().createQuery("from Rate r where r.date=:date").
                setParameter("date", date).list();
        return out;
    }

    @Transactional
    @Override
    public List<Currency> list() {
        List<Currency> list = session().createQuery("from Currency").list();
        return list;
    }

    @Transactional
    @Override
    public void add(Currency currency) {

        Currency existingCurrency = (Currency) session().
                createQuery("from Currency c where c.dcode=:dcode").
                setParameter("dcode", currency.getDcode()).uniqueResult();

        if (existingCurrency == null) {
            session().save(currency);
        } else {
            Currency c = (Currency) session().get(Currency.class, existingCurrency.getId());
            System.out.println("Currency already exists: " + existingCurrency);
            System.out.println("Updating rates...");
            for (Rate r : currency.getRates()) {
                Rate existingRate = (Rate) session().
                        createQuery("from Rate r where r.date=:date and r.currency.id=:currency_id").
                        setParameter("date", r.getDate()).setParameter("currency_id", existingCurrency.getId()).
                        uniqueResult();
                if (existingRate == null) {
                    r.setCurrency(c);
                    c.getRates().add(r);
                } else {
                    System.out.println("Existing rate skipped: " + existingRate);
                }
            }
        }
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
