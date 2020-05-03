import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String args[]) {

      List<String> rawValues = Arrays.asList(new String[] { "Adam", "Allan","Anna","John","Paul","Peter" });
      List<String> people =  rawValues
                            .stream()
                            .distinct()
                            .sorted()
                            .filter( name -> name.startsWith("A"))
                            .map(String::toUpperCase)
                            .limit(2)
                            .collect(Collectors.toList());
      System.out.println("first 2 People who started with A: " + people);
    }
}
