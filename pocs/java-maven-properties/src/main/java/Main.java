import java.io.IOException;

public class Main{
  public static void main(String args[]) throws IOException {
    PropertiesReader reader = new PropertiesReader("properties-from-pom.properties");
    String property = reader.getProperty("maven.compiler.target");
    System.out.println(property);
    System.out.println(reader.getProperty("name"));
    System.out.println(reader.getProperty("version"));
  }
}
