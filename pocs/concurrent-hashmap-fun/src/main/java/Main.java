import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main{
  public static void main(String args[]){
    Map<String,String> capitals = new ConcurrentHashMap<>();
    capitals.put("RS","Porto Alegre");
    capitals.put("SC","Florianopolis");
    capitals.put("CA","Sacramento");
    capitals.put("NY","New York City");
    capitals.put("CO","Bolder");
    System.out.println(capitals.keySet());

    capitals.putIfAbsent("PR","Curitiba");
    System.out.println(capitals.get("PR"));
    System.out.println(capitals.keySet());

    capitals.replace("CO","Bolder","Denver");
    System.out.println(capitals.get("CO"));
    System.out.println(capitals.keySet());

    Map<String,String> unmodifiableMap = Collections.unmodifiableMap(capitals);
    System.out.println(unmodifiableMap.keySet());
    try{
      unmodifiableMap.put("CO","South Park");
    }catch(UnsupportedOperationException e){}
    System.out.println(capitals.get("CO"));

  }
}
