import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

public class Main {
    public static void main(String args[]) {

        String input = "{\n" +
                "  \"order\": 4711,\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"name\": \"NE555 Timer IC\",\n" +
                "      \"cat-id\": \"645723\",\n" +
                "      \"quantity\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"LM358N OpAmp IC\",\n" +
                "      \"cat-id\": \"764525\",\n" +
                "      \"quantity\": 2\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        JsonObject object = Json.parse(input).asObject();
        JsonArray array = object.get("items").asArray();

        System.out.println(array);
        System.out.println(array.get(0).asObject());
        System.out.println(array.get(0).asObject().get("name").asString());
    }
}
