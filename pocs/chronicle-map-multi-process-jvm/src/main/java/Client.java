import net.openhft.chronicle.core.values.LongValue;
import net.openhft.chronicle.map.ChronicleMap;
import net.openhft.chronicle.values.Values;

import java.io.File;

public class Client {
    public static void main(String[] args) throws Exception{

        ChronicleMap<LongValue, CharSequence> ipc = ChronicleMap
                .of(LongValue.class, CharSequence.class)
                .entries(10)
                .averageValueSize(10D)
                .createPersistedTo(new File(new File(".").getAbsoluteFile() + "/jvm-ipc.dat"));

        LongValue key = Values.newHeapInstance(LongValue.class);
        key.setValue(1);

        CharSequence message = ipc.remove(key);
        if (message != null) {
            System.out.println("GOT : " + message);
        }
        System.out.println("FIN.");
    }
}
