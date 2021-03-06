package com.api.sipain.Oauth2;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOAuth2Exception extends OAuth2Exception  {
 
	public CustomOAuth2Exception(String msg) {
        super(msg); 
    } 
}
