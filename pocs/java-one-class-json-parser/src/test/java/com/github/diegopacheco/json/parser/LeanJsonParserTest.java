package com.github.diegopacheco.json.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeanJsonParserTest {

    @Test
    public void simpleJsonParser(){
        LeanJsonParser.JSONObject jsonObject = LeanJsonParser.parse("{\"rs\": \"POA\", \"sc\": \"Floripa\"}") ;
        assertNotNull(jsonObject.getValue("rs"));
        assertNotNull(jsonObject.getValue("sc"));
        assertEquals("POA",jsonObject.getValue("rs"));
        assertEquals("Floripa",jsonObject.getValue("sc"));
    }

    @Test
    public void arrayJsonParser(){
        LeanJsonParser.JSONObject jsonObject = LeanJsonParser.parse("{\"rs\": [{\"capital\": \"POA\"}], \"sc\": \"Floripa\"}") ;
        assertNotNull(jsonObject.getJSONArray("rs"));
        assertNotNull(jsonObject.getJSONArray("rs").getObject(0));
        assertEquals("POA", jsonObject.getJSONArray("rs").getJSONObject(0).getValue("capital"));
    }

    @Test
    public void nullJsonParser(){
        assertThrows(IllegalArgumentException.class, () -> {
            LeanJsonParser.JSONObject jsonObject = LeanJsonParser.parse(null);
        });
    }

    @Test
    public void emptyJsonParser(){
        assertThrows(IllegalArgumentException.class, () -> {
            LeanJsonParser.JSONObject jsonObject = LeanJsonParser.parse("");
        });
    }

    @Test
    public void invalidJsonParser(){
        assertThrows(IllegalStateException.class, () -> {
            LeanJsonParser.JSONObject jsonObject = LeanJsonParser.parse("{");
        });
    }

}
