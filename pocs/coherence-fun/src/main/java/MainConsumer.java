import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedMap;

/**
 * -Dcoherence.wka=localhost
 */
public class MainConsumer {
    public static void main(String args[]){
        NamedMap<String, String> map = CacheFactory.getCache("welcomes");

        System.out.printf("Accessing map \"%s\" containing %d entries\n",
                map.getName(),
                map.size());

        map.entrySet().forEach(System.out::println);
        System.out.println("DONE.");
    }
}
