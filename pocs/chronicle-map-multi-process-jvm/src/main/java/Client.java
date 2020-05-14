import net.openhft.chronicle.core.values.StringValue;
import net.openhft.chronicle.map.ChronicleMap;

import java.io.File;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception{
        ChronicleMap<StringValue, CharSequence> ipc = ChronicleMap
                .of(StringValue.class, CharSequence.class)
                .name("country-map")
                .entries(50)
                .averageKeySize(10D)
                .averageValue("Works")
                .createPersistedTo(new File(new File(".").getAbsoluteFile() + "/jvm-ipc.dat"));

        CharSequence message = ipc.remove("1");
        if (message != null) {
            System.out.println("GOT : " + message);
        }
        System.out.println("FIN.");
    }
}
