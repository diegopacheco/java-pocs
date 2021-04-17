import jetbrains.exodus.bindings.StringBinding;
import jetbrains.exodus.env.Environment;
import jetbrains.exodus.env.Environments;
import jetbrains.exodus.env.Store;
import jetbrains.exodus.env.StoreConfig;

public class Main{
  public static void main(String args[]){
    try (Environment env = Environments.newInstance("target/.myAppData")) {
      env.executeInTransaction(txn -> {
        final Store store = env.openStore("Messages", StoreConfig.WITHOUT_DUPLICATES, txn);
        store.put(txn, StringBinding.stringToEntry("Hello"), StringBinding.stringToEntry("World!"));
        System.out.println("Store: " + store.get(txn, StringBinding.stringToEntry("Hello")));
      });
      System.out.println("done.");
    }
  }
}
