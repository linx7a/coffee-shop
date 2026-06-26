package coffeeshop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("coffeeshop")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class AppConfig {
}
