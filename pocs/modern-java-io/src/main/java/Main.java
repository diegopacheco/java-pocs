import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private final String basePath;

    public Main() {
        try {
            basePath = new File(".").getCanonicalPath() + "/src/main/resources/";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.readFile();
        main.allLines().forEach(System.out::println);
        main.write("959429;ramondoe;67;yes\n");
        main.readFile();
    }

    public void readFile() throws IOException {
        String content = Files.readString(Path.of(basePath + "flat_file.txt"));
        System.out.println(content);
    }

    public List<String> allLines() throws IOException {
        return Files.readAllLines(Path.of(basePath + "flat_file.txt"));
    }

    public void write(String content) throws IOException {
        Files.writeString(Path.of(basePath + "flat_file.txt"), content, java.nio.file.StandardOpenOption.APPEND);
    }

}
