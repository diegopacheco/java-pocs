import org.agrona.collections.Int2IntCounterMap;
import org.agrona.collections.IntHashSet;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Int2IntCounterMap map = new Int2IntCounterMap(3);
        map.put(2, 4);
        map.put(4, 8);
        map.put(8, 16);

        for (String k : Arrays.asList("2", "4", "8")) {
            System.out.println(map.get(Integer.parseInt(k)));
        }

        IntHashSet set = new IntHashSet();
        set.add(100);
        set.add(200);
        set.add(300);
        for (int k : new int[]{100, 200, 300}) {
            System.out.println(set.remove(k));
        }

    }
}
