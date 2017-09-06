package sos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sos.services.UserServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private UserServiceImpl userDetailsServiceImpl;
	//@Autowired private CustomTokenBasedRememberMeService tokenBasedRememberMeService;
	//@Autowired private RememberMeAuthenticationProvider rememberMeAuthenticationProvider;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
	    .csrf().disable().cors().disable().httpBasic()
	    .and().authorizeRequests()
	    .antMatchers("/","/api/user/{userId}").permitAll().anyRequest().authenticated()
        .and()///added 6/9 from here
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/loginprocess")
        .failureUrl("/mobile/app/sign-in?loginFailure=true")
        .permitAll();
	}
	
	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}
	*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("passcode").roles("USER");
    }
    
    ///added 6/9
 
	 
	 @Bean @Override public AuthenticationManager authenticationManagerBean() throws Exception {
		 return super.authenticationManagerBean();
	 }
	 
	 @Bean public BCryptPasswordEncoder bCryptPasswordEncoder(){
		 return new BCryptPasswordEncoder();
	 }
    
}