
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new InfinitCounter();
        thread.start();

        Thread.sleep(5000L);
        thread.interrupt();
    }
}
