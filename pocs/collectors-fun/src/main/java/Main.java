import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main{
  public static void main(String args[]){

    List<String> names = Arrays.asList(new String[]{"Diego","Andressa","Gandalf","Melina"});
    Map<String,String> nameMap = names
            .stream()
            .map( e -> e.toLowerCase() )
            .collect(Collectors.toMap(String::new, Function.identity()));
    System.out.println(nameMap);
  }
}
