import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main{
  public static void main(String args[]){

    List<String> names = Arrays.asList("Diego","Andressa","Gandalf","Melina");
    Map<String,String> nameMap = names
            .stream()
            .map( e -> e.toLowerCase() )
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
  }
}
