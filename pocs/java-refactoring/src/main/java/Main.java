import java.util.Optional;

public class Main{
    public static void main(String[] args) {
        Optional<Formatter> f = FormatterBuilder.build("up");
        System.out.println(f.get().format("this is working"));
    }
}
