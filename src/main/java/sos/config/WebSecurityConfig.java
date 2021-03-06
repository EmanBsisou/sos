package sos.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
	       .antMatchers(HttpMethod.GET, "/api/geolocation/").permitAll()
	       .antMatchers(HttpMethod.GET, "/GeoLocationHandler").permitAll()
	      // .antMatchers(HttpMethod.POST, "/api/user/").permitAll()//no I dont want full user details in browser
	       .antMatchers(HttpMethod.POST, "/api/responser/*").permitAll()
	       .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()//25/9
	    //   .antMatchers(HttpMethod.GET, "/api/user/*").permitAll()//will allow get from browser
	       .antMatchers(HttpMethod.GET, "/api/responser/*").permitAll()
	       //.antMatchers(HttpMethod.GET, "/api/user/").authenticated()
	       .anyRequest().authenticated();                
	}
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("passcode").roles("USER");
    }

}