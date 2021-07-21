import java.io.PrintWriter;
import java.io.StringWriter;

public class Main{
  public static void main(String args[]){
    Exception e = new RuntimeException(new IllegalStateException(new IllegalArgumentException("no args with code!")));

    StringWriter sw = new StringWriter();
    e.printStackTrace(new PrintWriter(sw));

    String stackTrace = sw.toString();
    System.out.println(stackTrace);
  }
}
