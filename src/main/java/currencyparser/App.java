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
        }else{
            p.run();
        }
<<<<<<< HEAD

        System.out.println("local change in development");
        System.out.println("Sobaka");
        boolean devMode = false;
        if(devMode){
            System.out.println("I'm in DevMode!");
            System.out.println("I'm in DevMode 2!");
        }
=======
>>>>>>> 6c44044f2f0d774e9a1ea099cb70391ac4a24287
    }
}
