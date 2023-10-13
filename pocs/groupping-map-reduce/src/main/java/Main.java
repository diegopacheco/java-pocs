import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main{
  public static void main(String args[]){
    String str = "abcaadcbcb";
    Map<Character,Long> hm = str.chars()
                            .mapToObj(c-> (char)c)
                            .collect(Collectors
                                    .groupingBy(c->c,Collectors.counting()));
    System.out.println("Char Counts v1: " + hm);


    str = "abcaadcbcb";
    Map<Character, Integer> charCount = str.chars()
            .boxed()
            .collect(Collectors.toMap(
                    k -> (char) k.intValue(),
                    v -> 1,
                    Integer::sum));
    System.out.println("Char Counts v2: " + charCount);

    //
    // my way - Diego Pacheco
    //
    charCount = new HashMap<>();
    for(Character c: str.toCharArray()){
      charCount.merge(c,1,Integer::sum);
    }
    System.out.println("Char Counts v3: " + charCount);
  }
}
