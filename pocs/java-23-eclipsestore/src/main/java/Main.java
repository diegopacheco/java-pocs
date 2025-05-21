import org.eclipse.store.storage.embedded.types.EmbeddedStorage;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        final EmbeddedStorageManager storageManager = EmbeddedStorage.start();

        System.out.println(storageManager.root());
        storageManager.setRoot("Hello World! @ " + new Date());
        storageManager.storeRoot();
        storageManager.shutdown();
    }
}
