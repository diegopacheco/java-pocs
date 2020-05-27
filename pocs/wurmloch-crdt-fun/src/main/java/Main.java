import com.netopyr.wurmloch.crdt.GSet;
import com.netopyr.wurmloch.store.LocalCrdtStore;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class Main {

    public static void main(String args[]) {
        LocalCrdtStore crdtStore1 = new LocalCrdtStore();
        LocalCrdtStore crdtStore2 = new LocalCrdtStore();

        crdtStore1.connect(crdtStore2);
        GSet<String> replica1 = crdtStore1.createGSet("ID_1");
        GSet<String> replica2 = (GSet) crdtStore2.findGSet("ID_1").get();
        replica1.add("apple");
        replica2.add("banana");

        MatcherAssert.assertThat(replica1, Matchers.containsInAnyOrder(new String[]{"apple", "banana"}));
        MatcherAssert.assertThat(replica2, Matchers.containsInAnyOrder(new String[]{"apple", "banana"}));

        crdtStore1.disconnect(crdtStore2);
        replica1.add("strawberry");
        replica2.add("pear");

        MatcherAssert.assertThat(replica1, Matchers.containsInAnyOrder(new String[]{"apple", "banana", "strawberry"}));
        MatcherAssert.assertThat(replica2, Matchers.containsInAnyOrder(new String[]{"apple", "banana", "pear"}));

        crdtStore1.connect(crdtStore2);
        MatcherAssert.assertThat(replica1, Matchers.containsInAnyOrder(new String[]{"apple", "banana", "strawberry", "pear"}));
        MatcherAssert.assertThat(replica2, Matchers.containsInAnyOrder(new String[]{"apple", "banana", "strawberry", "pear"}));
        System.out.println("CRDTs works!");
    }
}
