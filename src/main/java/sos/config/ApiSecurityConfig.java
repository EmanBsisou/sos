package sos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import sos.services.UserServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private String tokenKey = "some token goes here";
	
	@Autowired private UserServiceImpl userDetailsServiceImpl;

	@Override protected void configure(HttpSecurity http) throws Exception {
        http
        	.antMatcher("/api/**")//api/**  /user/{userId}
        	.csrf()
        		.disable()
            .authorizeRequests().anyRequest().authenticated().and()/*
        	.addFilterBefore(rememberMeAuthenticationFilter(), BasicAuthenticationFilter.class )*/
        		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        		.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }
}

