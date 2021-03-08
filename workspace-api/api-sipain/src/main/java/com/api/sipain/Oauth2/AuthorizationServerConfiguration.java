package com.api.sipain.Oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configurable
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
	private String clientId;
	
	@Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
	private String clientSecret;	
	
	@Value("${security.oauth2.client.access-token-validity-seconds}")
	private Integer accessTokenValiditySeconds;
	
	@Value("${security.oauth2.client.refresh-token-validity-seconds}")
	private Integer refreshTokenValiditySeconds; 
	   
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
	   		"MIICXAIBAAKBgQCHJhFUa78jK50Uz4eFob0hKTMbC9jzDNbbV3oM+SOaYFzkAkLU\r\n" + 
	   		"9i5J3E58JYEMPMAZ0S2Gb/JaR7709MbBvxHMohwezKvbzkfHmgRxTRO420kDQUUg\r\n" + 
	   		"BsGoBszB3yqS5R/thJePLWaHWR53sIKQEEdwfTaxC2b3VMFXyExubl4NnwIDAQAB\r\n" + 
	   		"AoGARNCTXmMGjgf1EdWh8d8rCCmMRidALnHJLSJbmSN6h26tncOw9/LqGt28cOY/\r\n" + 
	   		"0VVVk0+5WIzD4EhL6TqBwcFidAwsctptHhnXQG9AIro37VreeOAPTiNdoqImdTOg\r\n" + 
	   		"MXwyaQ53Wpth7ApuwiYmlbWbENOFF2qJGroLUEajoGccVCECQQDDCiHZdedunBm/\r\n" + 
	   		"csSd2xVB7H00s2BSS0nD8dZX3gbnEhci6XKevn2PLwnrYHj4onKhY/TzWl1IZ3gc\r\n" + 
	   		"+UIxLtzXAkEAsWPV9NpKbQoZPIfPIIZygqO7p2U4ufENRDZay9N3OuvIC1tH+P7a\r\n" + 
	   		"ov0Aw/oPolcjJ0Anmyb3hmuvQxWfoQQ0eQJBAIsxy/6autSh625Kxi+yj3VBBgp6\r\n" + 
	   		"ih+xQ6/oBIUpG9wFeSWdXgQVBx8M/xNRAoTPyueLouGaeECYN4zWB3t6ankCQG2R\r\n" + 
	   		"XPaAXrg7JJtex3EvmktXFvGuc/tmCOu5Jxv+4gZi3I0nNK13vVQvMena6w07BVuZ\r\n" + 
	   		"JN2QlBNTME4fbRnnnwECQFOrMkZOk3356UIh/rcmv5UcYZ7atWOa+FmJRWYb2LIL\r\n" + 
	   		"yfHc7gF85Dqn85v1mU0iQ/g+u6cp6eu0OziLhFF4TVc=\r\n" + 
	   		"-----END RSA PRIVATE KEY-----";
	   
	private String publicKey = "-----BEGIN PUBLIC KEY-----\r\n" + 
	   		"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCHJhFUa78jK50Uz4eFob0hKTMb\r\n" + 
	   		"C9jzDNbbV3oM+SOaYFzkAkLU9i5J3E58JYEMPMAZ0S2Gb/JaR7709MbBvxHMohwe\r\n" + 
	   		"zKvbzkfHmgRxTRO420kDQUUgBsGoBszB3yqS5R/thJePLWaHWR53sIKQEEdwfTax\r\n" + 
	   		"C2b3VMFXyExubl4NnwIDAQAB\r\n" + 
	   		"-----END PUBLIC KEY-----";
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder oauthClientPasswordEncoder;
     
    @Autowired
    ResponseExceptionTranslator oauthexceptionTranslator;
    
    @Autowired
    AutenticationEntryPoint authEntryPoint;
    
    
    @Bean
	public JwtTokenStore tokenStore() {
	      return new JwtTokenStore(tokenEnhancer());
	}
    
    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      converter.setSigningKey(privateKey);
      converter.setVerifierKey(publicKey);
      return converter;
    }
 
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()")
        .passwordEncoder(oauthClientPasswordEncoder); 
        CustomClientCredentialsTokenEndpointFilter endpointFilter = new CustomClientCredentialsTokenEndpointFilter(security);
        endpointFilter.afterPropertiesSet();
        endpointFilter.setAuthenticationEntryPoint(authEntryPoint);
        security.addTokenEndpointAuthenticationFilter(endpointFilter);
    }
    
    @Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	clients.inMemory().withClient(clientId)
	      .secret(oauthClientPasswordEncoder.encode(clientSecret))
	      .scopes("read")
	      .authorizedGrantTypes("password", "refresh_token")
	      .accessTokenValiditySeconds(accessTokenValiditySeconds)
	      .refreshTokenValiditySeconds(refreshTokenValiditySeconds);
	   }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)  {
        endpoints.tokenStore(tokenStore())
        .accessTokenConverter(tokenEnhancer())
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService)  
        .exceptionTranslator(oauthexceptionTranslator); 
    } 
}
