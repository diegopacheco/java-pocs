import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class Main{
  public static void main(String args[]) throws Exception {
    Logger logger = LoggerFactory.getLogger("splunk.logger.java");
    logger.info("This is going to splunk. app=mainapp env=local test=true");
    logger.error("This is a test error for log4j test app=mainapp env=local test=true");
    logger.error("here is a stack there " + new RuntimeException(new RuntimeException(new IOException("fake"))));
    logger.info("DONE! app=mainapp env=local test=true");
    Thread.sleep(5000);
  }
}
