package com.api.sipain.Oauth2;
 
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception; 
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component; 

@Component
public class ResponseExceptionTranslator implements WebResponseExceptionTranslator<OAuth2Exception>   {

	@Override
	public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		 OAuth2Exception auth2Exception = (OAuth2Exception)e; 
	        return ResponseEntity
	                .status(auth2Exception.getHttpErrorCode())
	                .body(new CustomOAuth2Exception(auth2Exception.getMessage()));
	} 
}

