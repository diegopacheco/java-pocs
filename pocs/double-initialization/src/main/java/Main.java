import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        try (Config config = new Config()) {
            config.init();
            System.out.println("Config Downstream Dependencies: " + config.getDownstreamDependencies());
        }

        ConfigV2 v2 = new ConfigV2();
        System.out.println("Config Downstream Dependencies: " + v2.getDownstreamDependencies());
    }
}
