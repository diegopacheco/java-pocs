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
    public void complexObjectJsonParser(){
        String json = "{\n" +
                "\t\"id\": \"0001\",\n" +
                "\t\"type\": \"donut\",\n" +
                "\t\"name\": \"Cake\",\n" +
                "\t\"ppu\": 0.55,\n" +
                "\t\"batters\":\n" +
                "\t\t{\n" +
                "\t\t\t\"batter\":\n" +
                "\t\t\t\t[\n" +
                "\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
                "\t\t\t\t]\n" +
                "\t\t},\n" +
                "\t\"topping\":\n" +
                "\t\t[\n" +
                "\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                "\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                "\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
                "\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
                "\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "\t\t]\n" +
                "}";
        LeanJsonParser.JSONObject jsonObject = LeanJsonParser.parse(json);
        assertNotNull(jsonObject.getJSONArray("id"));
        assertNotNull(jsonObject.getValue("batters"));
        assertNotNull(LeanJsonParser.parse(jsonObject.getValue("batters")));
        assertNotNull(LeanJsonParser.parse(jsonObject.getValue("batters")).getJSONArray("batter"));
        assertNotNull(LeanJsonParser.parse(jsonObject.getValue("batters")).getJSONArray("batter").getObject(0));
        System.out.println(LeanJsonParser.parse(jsonObject.getValue("batters")).getJSONArray("batter").getObject(0));
        //assertEquals("Regular",jsonObject.getJSONArray("batters").getJSONObject(0).getValue("type"));
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
