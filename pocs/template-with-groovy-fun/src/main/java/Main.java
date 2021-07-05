import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
  public static void main(String args[]){
    SimpleTemplateEngine templateEngine = new SimpleTemplateEngine();

    String groovyCodeTemplate = "Dear \"$firstname $lastname\",\\n" +
            "So nice to meet you in <% print city %>." +
            "\\nSee you in ${month},\\n${signed}";

    Map<String,String> bindings = new HashMap<>();
    bindings.put("firstname","John");
    bindings.put("lastname","Doe");
    bindings.put("city","Rome");
    bindings.put("month","July");
    bindings.put("signed","Robert Langdon");

    Template template = null;
    Writable w = null;
    try{
      template = templateEngine.createTemplate(
              new InputStreamReader(
                      new ByteArrayInputStream(groovyCodeTemplate.getBytes())));
      w = template.make(bindings);
    }catch(Exception e){
      throw new RuntimeException(e);
    }

    System.out.println(w.toString());
  }
}
