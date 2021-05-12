import com.github.diegopacheco.java.pocs.visibility.core.Readable;
import com.github.diegopacheco.java.pocs.visibility.core.protection.CacheLoader;
import com.github.diegopacheco.java.pocs.visibility.core.protection.ReaderProvider;

public class Main{
  public static void main(String args[]){
    // cant even get instance of CacheService cs = CacheService.getInstance();
    //cs.set(new LazyPair<>("1","1")); // dont compile: set is not visible and  since LazyPair is not public.

    CacheLoader.load();
    Readable<String> cs = ReaderProvider.get();
    System.out.println("From Cache: " + cs.get("1"));

  }
}
