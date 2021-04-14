import com.github.diegopacheco.javapocs.timeout.SilentThread;
import com.github.diegopacheco.javapocs.timeout.TimeOutManager;

import java.util.concurrent.Callable;

public class Main{
  public static void main(String args[]){
    System.out.println("TimeOutManager: " + TimeOutManager.class);

    String result = TimeOutManager.executeWithTimeout(3000, new Callable<String>() {
      @Override
      public String call() throws Exception {
        SilentThread.sleep(1);
        return "42";
      }
    });
    System.out.println("result: " + result);

    TimeOutManager.executeWithTimeout(3000, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        SilentThread.sleep(4);
        return 42;
      }
    });

  }
}
