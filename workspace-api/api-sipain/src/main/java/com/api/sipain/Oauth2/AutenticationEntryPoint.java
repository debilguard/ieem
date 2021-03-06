package com.api.sipain.Oauth2;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.api.sipain.entities.resError;

@Component
public class AutenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

	@Override
    protected ResponseEntity<resError> enhanceResponse(ResponseEntity<?> response, Exception exception) {
        return ResponseEntity.status(response.getStatusCode()).body(new resError("401", exception.getLocalizedMessage()));
    }
}
