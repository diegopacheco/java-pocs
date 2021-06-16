import tv.twelvetone.json.JsonValue;
import tv.twelvetone.rjson.RJsonParserFactory;

public class Main{
  public static void main(String args[]){
    JsonValue parsed = new RJsonParserFactory().createParser().stringToValue("{hello:world}");
    assert("{\"hello\":\"world\"}".equals(parsed.toString()));
    System.out.println(parsed.toString());
  }
}

