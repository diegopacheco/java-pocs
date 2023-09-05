
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Thread infinitThread = new InfinitCounter();
        infinitThread.start();
        infinitThread.join(); // Never gets interrupted. Remove it and it will.

        Thread stoableThread = new InfinitCounter();
        stoableThread.start();

        Thread.sleep(5000L);
        stoableThread.interrupt();
        infinitThread.interrupt();
    }
}
