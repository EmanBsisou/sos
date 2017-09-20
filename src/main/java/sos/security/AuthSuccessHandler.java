package sos.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
   // private static final Logger LOGGER = LoggerFactory.getLogger(AuthSuccessHandler.class);

  //  private final ObjectMapper mapper;

	  //  @Autowired
	 //   AuthSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
	 //       this.mapper = messageConverter.getObjectMapper();
	  //  }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);

        //NuvolaUserDetails userDetails = (NuvolaUserDetails) authentication.getPrincipal();
       // User user = userDetails.getUser();
      //  userDetails.setUser(user);

       // LOGGER.info(userDetails.getUsername() + " got is connected ");

        //PrintWriter writer = response.getWriter();
      //  mapper.writeValue(writer, user);
      //  writer.flush();
    }
}