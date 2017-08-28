package sos;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
/*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");//home
        registry.addViewController("/").setViewName("index");//home
        registry.addViewController("/index").setViewName("index");//hello
        registry.addViewController("/login").setViewName("login");
    }
*/
}
