import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static String stringMask(String a, String b) {
        return b + a.substring(Math.min(b.length(), a.length()));
    }

    public static void main(String[] args) {
        var fizzPattern = List.of("", "", "Fizz");
        var buzzPattern = List.of("", "", "", "", "Buzz");

        IntStream.range(0, 100).forEach(i -> {
            var fizz = fizzPattern.get(i % fizzPattern.size());
            var buzz = buzzPattern.get(i % buzzPattern.size());
            var number = String.valueOf(i + 1);
            System.out.println(stringMask(number, fizz + buzz));
        });
    }
}
