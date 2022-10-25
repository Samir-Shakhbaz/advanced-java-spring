package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/magazines.xml"})
public class MyConfigClass {

    @Bean
    public Book book() {
        return new Book("Great Expectations", "Charles Dickens");
    }
}
