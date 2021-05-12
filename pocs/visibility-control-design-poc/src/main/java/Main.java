import com.github.diegopacheco.java.pocs.visibility.core.protection.CacheLoader;
import com.github.diegopacheco.java.pocs.visibility.core.protection.CacheService;

public class Main{
  public static void main(String args[]){
    CacheLoader.load();
    CacheService cs = CacheService.getInstance();
    //cs.set(new LazyPair<>("1","1")); // dont compile: set is not visible and  since LazyPair is not public.
    System.out.println("From Cache: " + cs.get("1"));
  }
}
