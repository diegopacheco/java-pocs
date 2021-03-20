import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDateTime;
import java.util.Date;

public class Main{
  public static void main(String args[]){
    PrettyTime p = new PrettyTime();

    // Traditional Date API:
    System.out.println(p.format(new Date()));
    //prints: “moments from now”

    // JDK 8 DateTime API:
    System.out.println(p.format(LocalDateTime.now().minusSeconds(1)));
    //prints: “moments ago”

    System.out.println(p.format(new Date(System.currentTimeMillis() + 1000*60*10)));
    //prints: “10 minutes from now”
  }
}
