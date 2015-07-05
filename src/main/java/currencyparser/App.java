package currencyparser;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by eyevlyc on 12/15/2014.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
/*
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        HibernateUtils.setSessionFactory(sessionFactory);
*/



        Parser p = (Parser) ctx.getBean("parser");
        if(p == null){
            System.out.println("p is null");
            System.out.println("kot");
        }else{
            System.out.println(p);
            p.run();
        }
        System.out.println("Sobaka");
        boolean devMode = false;
        if(devMode){

            System.out.println("I'm in DevMode!");
        }
    }
}
