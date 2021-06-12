import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main{
  public static void main(String args[]){
    System.out.println("Specific property[answer]=="+getSpecificProperty());
    List<String> sources = getAllPropertyInTheJar();
    System.out.println("All properties inside the jar=="+sources);
    System.out.println("Exporting all props"); exportProperties(sources);
    System.out.println("config.db.name=="+System.getProperty("config.db.name"));
    System.out.println("config.db.host=="+System.getProperty("config.db.host"));
    System.out.println("config.metadata.appid=="+System.getProperty("config.metadata.appid"));
    System.out.println("config.metadata.owner=="+System.getProperty("config.metadata.owner"));
  }

  private static String getSpecificProperty(){
    Properties props = new Properties();
    try {
      props.load(Main.class.getResourceAsStream("app.properties"));
      return props.getProperty("answer");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static List<String> getAllPropertyInTheJar(){
      List<String> result = new ArrayList<>();
      JarFile jf = null;
      try {
        String s = new File(Main.class.getResource("Main.class").getPath())
                .getParent().replaceAll("(!|file:/)", "/")
                .replace("classes",""); // last one is to work with idea

        // just to work on idea - for the jar is not needed.
        if (!s.contains("properties-find-load-fun-1.0-SNAPSHOT.jar")){
            s+="properties-find-load-fun-1.0-SNAPSHOT.jar";
        }

        jf = new JarFile(s);
        Enumeration<JarEntry> entries = jf.entries();
        while (entries.hasMoreElements()) {
          JarEntry je = entries.nextElement();
          if (je.getName().endsWith(".properties")) {
            result.add(je.getName());
          }
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        try {
          jf.close();
        } catch (Exception e) {}
      }
      return result;
  }

  public static void exportProperties(List<String> sources){
      for(String propSource : sources){
          try {
              Properties props = new Properties();
              if (!propSource.startsWith("META-INF/maven/")){
                  props.load(Main.class.getResourceAsStream(propSource));
                  props.forEach( (k,v) -> {
                      System.setProperty((String)k,(String)v);
                  });
              }
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
  }

}
