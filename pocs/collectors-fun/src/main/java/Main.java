import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main{
  public static void main(String[] args){

    List<String> names = Arrays.asList("Diego","Andressa","Gandalf","Melina");
    Map<String,String> nameMap = names
            .stream()
            .map(String::toLowerCase)
            .collect(Collectors.toMap(String::new, Function.identity()));
    System.out.println(nameMap);

    List<String> listWithDuplicates = Arrays.asList("Gremio", "Gremio", "Gremio", "Barcelona", "Gremio");
    Set<String> result = listWithDuplicates.
            stream().
            collect(Collectors.toSet());
    System.out.println("Removed Duplicates: " + result);

    List<String> cities = Arrays.asList("Porto", "Cabo", "Rio", "Planalto", "Cachorro");
    String joined = cities.
            stream().
            collect(Collectors.joining(" velho, "));
    System.out.println("Joined: " + joined);

    List<Integer> numbers = Arrays.asList(1,10,42,34,27,32,3,18);
    IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::new));
    System.out.println("Max   : " + stats.getMax());
    System.out.println("Min   : " + stats.getMin());
    System.out.println("Avg   : " + stats.getAverage());
    System.out.println("Count : " + stats.getCount());
    System.out.println("Sum   : " + stats.getSum());
  }
}
