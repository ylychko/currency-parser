package currencyparser.dao.it;

import currencyparser.entity.Currency;
import currencyparser.entity.Rate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@TransactionConfiguration(defaultRollback = false)
public class CurrencyDaoIT extends CurrencyDaoTestBase {
    private Date date1;
    private Date date2;
    private Currency c1, c2;

    @Before
    public void setUp() throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        date1 = new Date(format.parse("1981-01-01").getTime());
        date2 = new Date(format.parse("1981-01-02").getTime());

        c1 = createCurrency("TEST-USD1", 55555);
        c1.getRates().add(createRate(234.5, 100, date1, c1));
        c1.getRates().add(createRate(222.5, 100, date2, c1));
        currencyDAO.add(c1);

        c2 = createCurrency("TEST-USD2", 66666);
        c2.getRates().add(createRate(123.5, 100, date1, c2));
        c2.getRates().add(createRate(111.5, 100, date2, c2));
        currencyDAO.add(c2);
    }

    @Test
    public void list() {
        System.out.println("list:");
        List<Currency> list = currencyDAO.list();

        for (Currency c : list) {
            System.out.print(c.getLcode() + " ");
        }
        assertFalse(list.isEmpty());
    }

    @Test
    public void listByDate() {
        System.out.println("listByDate, date1:");
        List<Rate> list = currencyDAO.list(date1);

        for (Rate r : list) {
            System.out.println(r);
        }
        assertEquals(2, list.size());

        System.out.println("listByDate, date2:");
        list = currencyDAO.list(date2);

        for (Rate r : list) {
            System.out.println(r);
        }
        System.out.println();
        assertEquals(2, list.size());
    }

    @After
    public void tearDown() throws Exception {
        session().delete(c1);
        session().delete(c2);
    }
}
