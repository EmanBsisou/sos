package sos.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//import sos.services.UserServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	       .csrf().disable()                
	       //.and()
	       .httpBasic()
	       .and()
	       .authorizeRequests()                
	       .antMatchers(HttpMethod.GET, "/*").permitAll()
	       .antMatchers(HttpMethod.GET, "/api/geolocation/*").permitAll()
	       .antMatchers(HttpMethod.GET, "/GeoLocationHandler").permitAll()
	    //   .antMatchers(HttpMethod.GET, "/api/user/*").permitAll()//will allow get from browser
	       .antMatchers(HttpMethod.GET, "/api/responser/*").permitAll()
	       .antMatchers(HttpMethod.GET, "/api/user/{userId}").authenticated()
	       .anyRequest().authenticated();                
	}

 /*   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("passcode").roles("USER");
    }*/
    
  
    
}