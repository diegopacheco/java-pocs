
public class Main{
  public static void main(String args[]){
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println("Singleton s1: " + s1.getId());
    System.out.println("Singleton s2: " + s2.getId());
    System.out.println("Same instance: " + (s1 == s2));

    LazyResult<String> lazyResult = LazyResult.of(() -> {
      System.out.println("Computing expensive operation...");
      return "Result-" + System.currentTimeMillis();
    });
    System.out.println("LazyResult created (not computed yet)");
    System.out.println("First access: " + lazyResult.get());
    System.out.println("Second access: " + lazyResult.get());

    StableCounters counters = StableCounters.getInstance();
    counters.incrementSuccess();
    counters.incrementSuccess();
    counters.incrementSuccess();
    counters.incrementError();
    System.out.println("Counters: " + counters.getStats());

    Thread[] threads = new Thread[10];
    for (int i = 0; i < threads.length; i++) {
      final int index = i;
      threads[i] = new Thread(() -> {
        if (index % 3 == 0) {
          counters.incrementError();
        } else {
          counters.incrementSuccess();
        }
      });
      threads[i].start();
    }

    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("After concurrent updates: " + counters.getStats());
  }
}
