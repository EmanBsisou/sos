package sos;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ApbApplication {//added extends...
	  @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }

	public static void main(String[] args) {
		SpringApplication.run(ApbApplication.class, args);
	}
	/*added 8/9
	 @RequestMapping("/token")
	  public Map<String,String> token(HttpSession session) {
	    return Collections.singletonMap("token", session.getId());
	  }
	*/
	@GetMapping("/api")
	public String sosApi(){
		return "SOS rest API";
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic().and()
	      .authorizeRequests()
	        .antMatchers("/index.html",  "/login.html", "/").permitAll().anyRequest()
	        .authenticated().and()
	      .csrf()
	        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	  }
	}
}
