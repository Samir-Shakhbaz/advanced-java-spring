package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.CoreLabConfig;
import platform.codingnomads.co.corespring.lab.complete.Record;
import platform.codingnomads.co.corespring.lab.complete.Turntable;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                MyConfigClass.class);

        Book book = ctx.getBean(Book.class);

        System.out.println("If you something light to read try" + book.title + "by" + book.author +".");


        String[] magazines = ctx.getBeanNamesForType(Magazine.class);

        for (String magazine : magazines) {
            System.out.println("I recommend you read " + ctx.getBean(magazine, Magazine.class).getName()
                    + "published in " + ctx.getBean(magazine, Magazine.class).getYear() + ".");
        }

    }
}

