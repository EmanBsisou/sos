package sos;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;


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
/*
	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic().and()
	      .authorizeRequests()
	        .antMatchers("/index.html", "/{userId}",   "/login.html", "/").permitAll().anyRequest()
	        .authenticated().and()
	      .csrf()
	        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	  }
	}*/
	
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		  @Override
		  protected void configure(HttpSecurity http) throws Exception {
		    http
		      .httpBasic()
		      .and()
		      .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		  }
		}
	public class CsrfHeaderFilter extends OncePerRequestFilter {
		  @Override
		  protected void doFilterInternal(HttpServletRequest request,
		      HttpServletResponse response, FilterChain filterChain)
		      throws ServletException, IOException {

		    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		    if (csrf != null) {
		      Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
		      String token = csrf.getToken();
		      if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
		        cookie = new Cookie("XSRF-TOKEN", token);
		        cookie.setPath("/");
		        response.addCookie(cookie);
		      }
		    }
		    filterChain.doFilter(request, response);
		  }
		}
}
