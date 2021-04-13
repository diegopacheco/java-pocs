import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{

  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String args[]){
    long init= System.currentTimeMillis();
    logger.info("booting up... ");
    for(int i=0;i<=1000000;i++){
      logger.info("i is: [" + i * 1 + "]");
    }
    logger.info("FIN.");
    long end = System.currentTimeMillis();
    System.out.println("execution time: " + (end-init) + "ms");
  }
}
