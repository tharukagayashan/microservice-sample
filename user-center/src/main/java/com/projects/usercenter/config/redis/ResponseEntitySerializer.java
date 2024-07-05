package com.projects.usercenter.config.redis;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class ResponseEntitySerializer extends JsonSerializer<ResponseEntity> {

    @Override
    public void serialize(ResponseEntity responseEntity, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("status", responseEntity.getStatusCode().value());
        gen.writeObjectField("body", responseEntity.getBody());
        gen.writeEndObject();
    }
}
