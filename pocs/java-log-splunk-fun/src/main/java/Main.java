import java.util.logging.Logger;

public class Main{
  public static void main(String args[]){
    Logger logger = Logger.getLogger("MainApp");
    logger.info("This is going to splunk. app=mainapp env=local test=true");
    logger.severe("This is a test error for log4j test app=mainapp env=local test=true");
    System.out.println("done");
  }
}
