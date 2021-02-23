
package com.api.sipain.Oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.sipain.service.UsuarioAutorizadoService;

@Configuration
@EnableWebSecurity

/*@EnableGlobalMethodSecurity(prePostEnabled = true)*/


public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioAutorizadoService usersService;
	
	 @Bean
	 public PasswordEncoder encoder() {
	      return new BCryptPasswordEncoder();
	   }
	  
	 @Override
	   @Autowired
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(usersService).passwordEncoder(encoder());
	   }
	 
	/* @Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
	         .sessionCreationPolicy(SessionCreationPolicy.NEVER);
	   }*/
	 
	 
	 @Override
	 public void configure (HttpSecurity http) throws Exception {
	 
		 /*http.authorizeRequests()
		 .antMatchers("http://localhost:8080/oauth/token", "/oauth/authorize **", "/publishes")
		 .permitAll();
		 anyRequest (). authenticated (); 

		 /*http.requestMatchers (). antMatchers ("/ private") // Deny access to "/ private"
		 .and (). authorizeRequests ()
		 .antMatchers ("/ private"). access ("hasRole ('USER')") 
		 .and (). requestMatchers (). antMatchers ("/ admin") // Deny access to "/ admin"
		 .and (). authorizeRequests ()
		 .antMatchers ("/ admin"). access ("hasRole ('ADMIN')");*/
		 /*http.requestMatchers()
		 .antMatchers("/oauth/authorize","/oauth/token")
		 .and()
		 .authorizeRequests()
		 .anyRequest()
		 .authenticated()
		 .and()
		 .formLogin()
		 .permitAll(); */
		 /*http.antMatcher("http://localhost:8080/**")
		 .authorizeRequests()
		 .antMatchers("/","login**","http://localhost:8080/oauth/**")
		 .permitAll()
		 .anyRequest()
		 .authenticated();*/
		 
		http.authorizeRequests()
		 .antMatchers("/oauth/token")
		 .permitAll()
		 .anyRequest()
		 .authenticated(); 
	 }
	  
	 @Override
	   public void configure(WebSecurity web) throws Exception {
	      web.ignoring();
	   }
	   
	 @Override
	   
	 @Bean
	   public AuthenticationManager authenticationManagerBean() throws Exception {
	      return super.authenticationManagerBean();
	   }
}
