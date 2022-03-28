import org.hjson.JsonObject;
import org.hjson.JsonValue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main{
  public static void main(String args[]){

    try {
      String base = new File(".").getCanonicalPath();

      String readerOrHjsonString = new String(
              Files.readAllBytes(Paths.get(base + "/src/main/resources/data.hjson")));

      String jsonString = JsonValue.readHjson(readerOrHjsonString).toString();
      System.out.println(jsonString);

      JsonObject jsonObject = JsonValue.readHjson(readerOrHjsonString).asObject();
      for (JsonObject.Member member : jsonObject) {
        String name = member.getName();
        JsonValue value = member.getValue();
        System.out.println("name: " + name + " value: " + value);
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
