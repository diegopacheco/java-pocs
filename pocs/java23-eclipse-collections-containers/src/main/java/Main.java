import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.multimap.ImmutableMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.Stacks;

public class Main {
    public static void main(String args[]) {
        //Initializing immutable list with empty(), of(), with() method
        ImmutableList<String> immutableListEmpty =
                Lists.immutable.empty();
        ImmutableList<String> immutableListOf =
                Lists.immutable.of("One", "One", "Two", "Three");
        ImmutableList<String> immutableListWith =
                Lists.immutable.with("One", "One", "Two", "Three");

        //Various container types available
        ImmutableSet<String> immutableSet =
                Sets.immutable.with("One", "One", "Two", "Three");
        ImmutableBag<String> immutableBag =
                Bags.immutable.with("One", "One", "Two", "Three");
        ImmutableStack<String> immutableStack =
                Stacks.immutable.with("One", "One", "Two", "Three");
        ImmutableMap<String, String> immutableMap =
                Maps.immutable.with("key1", "value1", "key2", "value2", "key3", "value3");
        ImmutableMultimap<String, String> immutableMultimapWithList =
                Multimaps.immutable.list.with("key1", "value1-1", "key1", "value1-2", "key2", "value2-1");
        ImmutableBiMap<String, String> immutableBiMap =
                BiMaps.immutable.with("key1", "value1", "key2", "value2", "key3", "value3");

        System.out.println("Immutable List Empty: " + immutableListEmpty);
        System.out.println("Immutable List Of: " + immutableListOf);
        System.out.println("Immutable List With: " + immutableListWith);
        System.out.println("Immutable Set: " + immutableSet);
        System.out.println("Immutable Bag: " + immutableBag);
        System.out.println("Immutable Stack: " + immutableStack);
        System.out.println("Immutable Map: " + immutableMap);
        System.out.println("Immutable Multimap with List: " + immutableMultimapWithList);
        System.out.println("Immutable BiMap: " + immutableBiMap);

    }
}
