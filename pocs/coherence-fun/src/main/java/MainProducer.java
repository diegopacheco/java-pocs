import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedMap;

/**
 * -Dcoherence.wka=localhost
 */
public class MainProducer {
  public static void main(String args[]){

    CacheFactory.ensureCluster();

    NamedMap<String, String> map = CacheFactory.getCache("welcomes");

    System.out.printf("Accessing map \"%s\" containing %d entries\n",
            map.getName(),
            map.size());

    map.put("english", "Hello");
    map.put("spanish", "Hola");
    map.put("french" , "Bonjour");
    map.put("portuguese","Bom Dia");

    map.entrySet().forEach(System.out::println);
    System.out.println("FIN.");

    CacheFactory.shutdown();
  }
}
