import net.openhft.chronicle.core.values.StringValue;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.values.Values;

import java.io.File;

public class Server {
  public static void main(String args[]) throws Exception {
    ChronicleMap<StringValue, CharSequence> ipc = ChronicleMap
            .of(StringValue.class, CharSequence.class)
            .name("country-map")
            .entries(50)
            .averageKeySize(10D)
            .averageValue("Works")
            .createPersistedTo(new File(new File(".").getAbsoluteFile() + "/jvm-ipc.dat"));

    StringValue key = Values.newHeapInstance(StringValue.class);
    key.setValue("1");
    ipc.put(key, "works");

    System.out.println("FIN.");
  }
}
