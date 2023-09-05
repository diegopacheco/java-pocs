import java.util.concurrent.atomic.AtomicInteger;

public class InfinitCounter extends Thread{

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        while(true){
            if (isInterrupted()){
                System.out.println("Thread Interrupted. ");
                System.out.println("END");
                break;
            }
            silentSleep(1);
            System.out.println(counter.getAndIncrement());
        }
    }

    private void silentSleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
