import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Map;

public class Main {
    public static void main(String args[]) throws Exception{
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        Map<String, Object> map = (Map<String, Object>) jsonObject;
        System.out.println(map);
    }
}
