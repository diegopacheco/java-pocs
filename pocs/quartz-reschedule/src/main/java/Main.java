import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

  public static class HelloJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException{
      System.err.println( new Date() + " Hello!  HelloJob is executing. Trigger: "
                         + context.getTrigger().getKey());
    }
  }

  public static void main(String args[]){
    try{
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDetail job = newJob(HelloJob.class)
         .withIdentity("job1", "group1")
         .build();

        Trigger trigger = newTrigger()
          .withIdentity("trigger1", "group1")
          .startNow()
                .withSchedule(simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever())            
          .build();
        scheduler.scheduleJob(job, trigger);

        Thread.sleep(5000L);

        // Re-schedulle
        Trigger trigger2 = newTrigger()
        .withIdentity("trigger2", "group1")
        .startNow()
          .withSchedule(simpleSchedule()
          .withIntervalInSeconds(3)
        .repeatForever()) 
        .forJob("job1", "group1")
        .build();

        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1","group1");
        scheduler.rescheduleJob(triggerKey, trigger2);        
        Thread.sleep(9000L);

        scheduler.shutdown();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
