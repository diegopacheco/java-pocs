import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class Main {

private static void formating(){
  System.out.println("Multi-line String...........");
    String jsonBlock = """
    {
        greeting: "Hello",
        audience: "World",
        punctuation: "!"
    }
    """;
    System.out.println(jsonBlock);
}

private static void switchfun(){
  System.out.println("Pattern Matcher...........");
  boolean result = switch (new Random().nextInt() % 1){
    case 0 -> {
        System.out.println("Bool true");
        yield true;
    }
    case 1 -> {
        System.out.println("Bool false");
        yield false;
    }
    default -> {
        System.out.println("DEFAULT");
        yield false;
    }
  };
  System.out.println(result);
  }

  public static void pattern_matcher_instanceof(Object obj){
    System.out.println("Pattern Matcher Instanceof ...........");
    if (obj instanceof String s) {
      System.out.println("obj is a String and it' length is " + s.length());
    }
  }

  static record Point(int x, int y){}

  public static void record_fun(){
    System.out.println("Records...........");
    var p = new Point(10,10);
    System.out.println("Point: " + p);
  }

  public static void convenience(){
    System.out.println("Convenience...........");
    Set<Integer> mySet = Set.of(1, 2, 3);
    List<Integer> myList = List.of(1, 2, 3);
    Map<String, Integer> myMap = Map.of("one", 1, "two", 2);
    System.out.println("Sets: " + mySet + " Lists: " + myList + " Maps: " + myMap);
  }

  public static void main(String args[]) {
    formating();
    switchfun();
    pattern_matcher_instanceof("ok");
    record_fun();
    convenience();
  }

}  
