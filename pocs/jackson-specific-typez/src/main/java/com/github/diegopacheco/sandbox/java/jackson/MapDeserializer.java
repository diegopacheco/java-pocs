package com.github.diegopacheco.sandbox.java.jackson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class MapDeserializer<K,V> extends KeyDeserializer {

	@Override
	public Map<K,V> deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Map<K,V> m = new ConcurrentHashMap<>();
		return m;
	}
}