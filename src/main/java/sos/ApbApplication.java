package sos;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ApbApplication {//added extends...
/*	  @RequestMapping("/api/user")
	  public Principal user(Principal user) {
	    return user;
	  }*/
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
