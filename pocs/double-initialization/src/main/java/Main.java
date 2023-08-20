import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        try (Config config = new Config()) {
            config.init();
            System.out.println("Config Downstream Dependencies: " + config.getDownstreamDependencies());
        }
    }
}
