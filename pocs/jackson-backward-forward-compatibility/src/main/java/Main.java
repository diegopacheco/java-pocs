
public class Main{

  /*
  * Caused by: com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException:
  * Unrecognized field "version" (class Config),
  * not marked as ignorable (3 known properties: "schema", "appName", "databaseURL"])
    at [Source: {"appName":"myEcomerce","databaseURL":"myecomerce.rds.us-west-2:2000","schema":"sales",
    "version": "2" }; line: 1, column: 101] (through reference chain: .Config["version"])
	at com.fasterxml.jackson.databind.exc.
	UnrecognizedPropertyException.from(UnrecognizedPropertyException.java:51)
  **/
  public static void main(String args[]){
    Config conf = new Config();
    conf.setAppName("myEcomerce");
    conf.setDatabaseURL("myecomerce.rds.us-west-2:2000");
    conf.setSchema("sales");
    String json = Parser.write(conf);
    System.out.println(json);

    //json = json.replace("appName","AppName"); // makes AppName == null
    json = json.replace("}",", \"version\": \"2\" }");
    System.out.println("Update Json: " + json);

    Config confNew = Parser.read(json);
    System.out.println("New Config: " + confNew);
  }
}
