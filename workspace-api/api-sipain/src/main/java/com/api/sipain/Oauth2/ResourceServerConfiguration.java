package com.api.sipain.Oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint; 

@Configuration
@EnableResourceServer

public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
	private OAuth2AuthenticationEntryPoint authEntryPoint;
	 
	 
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("api");     
		resources.authenticationEntryPoint(authEntryPoint); 
    }
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
    	.anonymous().disable()
    	.authorizeRequests()
    	.antMatchers("/oauth/","/oauth/token","/oauth/**")
    	.permitAll()
    	.anyRequest() 
    	.authenticated();
    } 
}