package com.api.sipain.Oauth2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.api.sipain.entities.resError;
import com.fasterxml.jackson.databind.ObjectMapper; 

@Component
public class AutenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

	@Autowired
	ObjectMapper mapper;
	private ServletServerHttpResponse res;
	
	@Override
    protected ResponseEntity<resError> enhanceResponse(ResponseEntity<?> response, Exception exception) {
        return ResponseEntity.status(response.getStatusCode()).body(new resError("401", exception.getLocalizedMessage()));
    }
    
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException {
    	res = new ServletServerHttpResponse(httpServletResponse);
        res.setStatusCode(HttpStatus.UNAUTHORIZED);
        res.getServletResponse().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        res.getBody().write(mapper.writeValueAsString(new resError("401",authException.getMessage())).getBytes());
    }
}
