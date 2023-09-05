
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Thread infinitThread = new InfinitCounter();
        Thread infiniteThread2 = new InfinitCounter();

        infiniteThread2.start();
        infinitThread.start();
        infinitThread.join(); // Never gets interrupted. Remove it and it will.

        Thread.sleep(5000L);
        infiniteThread2.interrupt();
        infinitThread.interrupt();
    }
}
