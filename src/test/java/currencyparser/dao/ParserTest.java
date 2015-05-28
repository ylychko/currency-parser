package currencyparser.dao;

import currencyparser.Parser;
import currencyparser.ParserStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by eyevlyc on 1/15/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class ParserTest {

    private Parser parser;

    @Mock
    private ParserStrategy strategy;

    @Before
    public void setup(){
        parser = new Parser(strategy);
    }

    @Test
    public void parserStrategy(){
        assertNotNull(parser.getParserStrategy());
    }
}
