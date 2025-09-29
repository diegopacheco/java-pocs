import com.coreoz.wisp.Scheduler;
import com.coreoz.wisp.schedule.Schedules;
import java.time.Duration;

public class Main{
  public static void main(String args[]){
    Scheduler scheduler = new Scheduler();
    scheduler.schedule(
      () -> System.out.println("My first job executed at: " + java.time.LocalDateTime.now()),           
      Schedules.fixedDelaySchedule(Duration.ofSeconds(1))
    );
    
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    
    scheduler.gracefullyShutdown();
  }
}
