import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.template.PebbleTemplate;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Main{
  public static void main(String args[]) throws IOException {

    String path = new File(".").getCanonicalPath() + "/src/main/webapp/WEB-INF/";

    PebbleEngine engine = new PebbleEngine.Builder().build();
    PebbleTemplate compiledTemplate = engine.getTemplate(path+"home.html");

    Map<String, Object> context = new HashMap<>();
    context.put("name", "Mitchell");

    Writer writer = new StringWriter();
    compiledTemplate.evaluate(writer, context);

    String output = writer.toString();
    System.out.println(output);
  }
}
