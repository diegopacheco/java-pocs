import com.github.diegopacheco.java.pocs.visibility.core.protection.CacheService;

public class Main{
  public static void main(String args[]){
    CacheService cs = CacheService.getInstance();
    cs.set("1","diego");
    System.out.println(cs.get("1"));
  }
}
