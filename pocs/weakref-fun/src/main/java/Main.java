import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Main{
  public static void main(String args[]) throws Exception{
    Object referent = new Object();
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

    WeakReference weakReference1 = new WeakReference<>(referent);
    WeakReference weakReference2 = new WeakReference<>(referent, referenceQueue);

    System.out.println("WeakRef 1 " + weakReference1);
    System.out.println("WeakRef 2 " + weakReference2);

    Object referent2 = weakReference1.get();
    System.out.println("Referent2 " + referent2);
    System.out.println("WeakRef 1 " + weakReference1);
    System.out.println("WeakRef 2 " + weakReference2);
    weakReference1.clear();
    weakReference2.clear();

    Object referent3 = weakReference2.get();
    while(true){
      System.gc();
      Thread.sleep(1000L);
      if (referent3 != null) {
        System.out.println("no gc");
        System.out.println("Ref3: " + referent3);
        // GC hasn't removed the instance yet
      } else {
        // GC has cleared the instance
        System.out.println("gc");
        System.out.println("Ref3: " + referent3);
        System.out.println("DONE");
        System.exit(0);
      }
    }
  }
}

