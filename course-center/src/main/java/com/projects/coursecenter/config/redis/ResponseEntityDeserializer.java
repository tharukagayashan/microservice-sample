package com.projects.coursecenter.config.redis;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class ResponseEntityDeserializer extends JsonDeserializer<ResponseEntity> {

    @Override
    public ResponseEntity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        HttpStatus status = HttpStatus.valueOf(node.get("status").intValue());
        JsonNode bodyNode = node.get("body");

        Object body = p.getCodec().treeToValue(bodyNode, Object.class);

        return new ResponseEntity<>(body, status);
    }
}
