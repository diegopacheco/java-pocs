import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{

  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String args[]){
    logger.debug("Debug Message Logged !!!");
    logger.info("Info Message Logged !!!");
    logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
  }
}
