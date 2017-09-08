package sos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController

public class ApbApplication {//added extends...
	
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
}
