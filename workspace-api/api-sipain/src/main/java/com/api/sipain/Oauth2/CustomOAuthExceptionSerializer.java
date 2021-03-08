package com.api.sipain.Oauth2;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException; 

  
public class CustomOAuthExceptionSerializer extends StdSerializer<CustomOAuth2Exception> {

	private static final long serialVersionUID = 1L;

	public CustomOAuthExceptionSerializer() {
        super(CustomOAuth2Exception.class);
    }

    @Override
    public void serialize(CustomOAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException { 
        gen.writeStartObject();
        gen.writeStringField("code", String.valueOf(value.getHttpErrorCode()));
        gen.writeStringField("message", value.getMessage());
        gen.writeEndObject();
    }
}
