package coffeeshop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("coffeeshop")
@EnableAspectJAutoProxy
public class AppConfig {
}
