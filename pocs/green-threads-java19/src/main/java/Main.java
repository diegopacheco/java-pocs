
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Thread thread = Thread.ofVirtual().
                unstarted(() -> System.out.println("Green Threads Baby"));
        thread.start();
        thread.join();
    }
}
