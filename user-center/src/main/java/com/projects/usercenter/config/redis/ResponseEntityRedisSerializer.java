package com.projects.usercenter.config.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class ResponseEntityRedisSerializer implements RedisSerializer<ResponseEntity> {

    private final ObjectMapper objectMapper;

    public ResponseEntityRedisSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public byte[] serialize(ResponseEntity responseEntity) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(responseEntity);
        } catch (IOException e) {
            throw new SerializationException("Error serializing ResponseEntity", e);
        }
    }

    @Override
    public ResponseEntity deserialize(byte[] bytes) throws SerializationException {
        try {
            return objectMapper.readValue(bytes, ResponseEntity.class);
        } catch (IOException e) {
            throw new SerializationException("Error deserializing ResponseEntity", e);
        }
    }
}
