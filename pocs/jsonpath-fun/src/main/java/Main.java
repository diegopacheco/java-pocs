import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class Main {

  public static void main(String args[]){

    try{
      String json = new String(Files.readAllBytes(Paths.get(new File(".").
                                     getAbsolutePath().replace(".", "") + 
                                     "/src/main/resources/json-file.json")
                               ));
      System.out.println("JSON FILE: \n"+json);  
                                          
      Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
      
      List<String> authors = JsonPath.read(document, "$.store.book[*].author");
      System.out.println("JSON PATH - All Book Authors : " + authors);

      Object r = JsonPath.parse(document).delete("$['store']['book'][3]['author']").json();
      r = JsonPath.parse(document).put("$['store']['book'][3]","author","Diego Pacheco").json();
      r = JsonPath.parse(document).put("$['store']['book'][3]","title","Build Applications with Scala").json();
      r = JsonPath.parse(document).put("$['store']['book'][3]","price","30.0").json();
      authors = JsonPath.read(r, "$.store.book[*].author");
      System.out.println("JSON PATH - All Book Authors : " + authors);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      JsonElement je = JsonParser.parseString(r.toString());
      String prettyJsonString = gson.toJson(je);
      System.out.println("FULL MODIFIED JSON:\n"+prettyJsonString);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
    
  }

}
