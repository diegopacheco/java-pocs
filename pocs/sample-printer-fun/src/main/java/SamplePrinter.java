import java.time.Duration;
import java.time.Instant;

public class SamplePrinter {

    private Instant watermark = Instant.now();

    public void print(String msg){
        Instant now = Instant.now();
        Duration delta = Duration.between(watermark, now);
        if (delta.getSeconds()>=30){
            System.out.println(msg);
            watermark = Instant.now();
        }
    }

}
