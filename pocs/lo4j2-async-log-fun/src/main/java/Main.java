import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main{

  private static final Logger asyncLogger = LogManager.getLogger(Main.class);
  private static final Logger consoleLogger = LogManager.getLogger("console");
    private static final List<String> totals = new ArrayList<>();

  public static void main(String args[]){
    sysOutLog();
    consoleLo4j2Log();
    asyncLo4j2Log();

    System.out.println("\n\n=== TOTALS: ");
    for(String bench : totals)
      System.out.println(bench);
  }

  private static void sysOutLog(){
    System.out.println("System Out Logger");
    long init= System.currentTimeMillis();
    System.out.println("booting up... ");
    for(int i=0;i<=1000000;i++){
      System.out.println("i is: [" + i * 1 + "]");
    }
    System.out.println("FIN.");
    long end = System.currentTimeMillis();
    System.out.println("execution time: " + (end-init) + "ms");
    totals.add("Sysout       = "+(end-init)+"ms");
  }

  private static void consoleLo4j2Log(){
    consoleLogger.info("Console - Sync Console Log4j2 log: ");
    long init= System.currentTimeMillis();
    consoleLogger.info("booting up... ");
    for(int i=0;i<=1000000;i++){
      consoleLogger.info("i is: [" + i * 1 + "]");
    }
    consoleLogger.info("FIN.");
    long end = System.currentTimeMillis();
    consoleLogger.info("execution time: " + (end-init) + "ms");
    totals.add("ConsoleLo4j2 = "+(end-init)+"ms");
  }

  private static void asyncLo4j2Log(){
    asyncLogger.info("ASYNC - RandonAccessFile Log4j2 Disruptor log: ");
    long init= System.currentTimeMillis();
    asyncLogger.info("booting up... ");
    for(int i=0;i<=1000000;i++){
      asyncLogger.info("i is: [" + i * 1 + "]");
    }
    asyncLogger.info("FIN.");
    long end = System.currentTimeMillis();
    asyncLogger.info("execution time: " + (end-init) + "ms");
    totals.add("AsyncLo4j2   = "+(end-init)+"ms");
  }

}
