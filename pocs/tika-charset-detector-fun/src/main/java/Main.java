import org.apache.tika.parser.txt.CharsetDetector;

import java.nio.charset.StandardCharsets;

public class Main{
  public static void main(String args[]){
    String yourStr = new String("Hi! Is this okay? é");
    CharsetDetector detector = new CharsetDetector();
    detector.setText(yourStr.getBytes());
    System.out.println(yourStr + " charset is: " +  detector.detect());

    yourStr = new String("\uD83C\uDFF3️".getBytes(StandardCharsets.UTF_16));
    detector = new CharsetDetector();
    detector.setText(yourStr.getBytes(StandardCharsets.UTF_16));
    System.out.println(yourStr + " charset is: " +  detector.detect());
  }
}
