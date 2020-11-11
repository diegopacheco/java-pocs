import java.util.Date;

public class Main{
  public static void main(String args[]) throws Exception {
    SamplePrinter printer = new SamplePrinter();
    long i=0;
    while(true){
      printer.print("going counting on... " + i + " @ " + new Date());
      i++;
      Thread.sleep(1);
    }
  }
}
