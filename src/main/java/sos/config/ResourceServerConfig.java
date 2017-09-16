package sos.config;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import oauth.AccessTokenValidator;
import oauth.GoogleAccessTokenValidator;
import oauth.GoogleTokenServices;
import sos.services.ResponserService;
import sos.services.UserService;
import sos.ws.GeoLocationHandler;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private OAuthProperties oAuthProperties;

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().anyRequest().hasRole("USER");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(oAuthProperties.getClientId());
    }

    @Bean
    public ResourceServerTokenServices tokenServices(OAuthProperties oAuthProperties, AccessTokenValidator tokenValidator) {
        GoogleTokenServices googleTokenServices = new GoogleTokenServices(tokenValidator);
        googleTokenServices.setUserInfoUrl(oAuthProperties.getUserInfoUrl());
        return googleTokenServices;
    }

    @Bean
    public AccessTokenValidator tokenValidator(OAuthProperties oAuthProperties) {
        GoogleAccessTokenValidator accessTokenValidator = new GoogleAccessTokenValidator();
        accessTokenValidator.setClientId(oAuthProperties.getClientId());
        accessTokenValidator.setCheckTokenUrl(oAuthProperties.getCheckTokenUrl());
        return accessTokenValidator;
    }
	///////////////Consider defining a bean of type 'sos.ws.GeoLocationHandler' in your configuration.
	@Bean
	public GeoLocationHandler geoLocationHandler(){
		return new GeoLocationHandler();
	}
	
	/////Consider defining a bean of type 'sos.services.ResponserService' in your configuration

	
	@MockBean
	ResponserService responserService;
	
}