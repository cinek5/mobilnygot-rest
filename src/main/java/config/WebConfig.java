package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Cinek on 04.10.2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.cinek")
public class WebConfig {
}
