import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        Gson gson = new Gson();
        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
        Map car = gson.fromJson(json, HashMap.class);
        System.out.println("JSON   : " + json);
        System.out.println("Object : " + car);
    }
}
