import java.io.File;
import java.io.FileInputStream;

public class Main {
    public static void main(String args[]) throws Exception {
        try (Config config = new Config()) {
            config.init();
            System.out.println("Config Downstream Dependencies: " + config.getDownstreamDependencies());
        }

        ConfigV2 v2 = new ConfigV2();
        System.out.println("Config Downstream Dependencies: " + v2.getDownstreamDependencies());

        try (ConfigV3 v3 = new ConfigV3(new FileInputStream(new File(Main.class.getResource("config.xml").toURI())))){
            System.out.println("Config Downstream Dependencies: " + v3.getDownstreamDependencies());
        }
    }
}
