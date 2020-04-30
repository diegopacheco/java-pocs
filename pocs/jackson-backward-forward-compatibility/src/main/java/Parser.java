import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    private static ObjectMapper om = new ObjectMapper();

    static{
        // FIX UnrecognizedPropertyException
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // FIX null for case sensitivity
        om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    public static Config read(String json){
        try{
            return om.readValue(json,Config.class);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String write(Config config){
        try{
            return om.writeValueAsString(config);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
