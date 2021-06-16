import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class Main{
  public static void main(String args[]){
    Configurations configs = new Configurations();
    try {
      Configuration config = configs.properties(new File("config.properties"));
      System.out.println(config);
      System.out.println(config.getString("database.host"));
      System.out.println(config.getString("database.password"));
    }
    catch (ConfigurationException e) {
      e.printStackTrace();
    }
  }
}
