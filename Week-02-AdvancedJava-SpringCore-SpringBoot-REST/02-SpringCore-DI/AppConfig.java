package week2.springcore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "week2.springcore")
public class AppConfig {
    // ComponentScan automatically detects @Component, @Service, @Repository, and @Controller classes
}
