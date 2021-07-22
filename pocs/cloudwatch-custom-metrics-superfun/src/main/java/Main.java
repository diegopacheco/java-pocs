import com.github.diegopacheco.cw.custom.metrics.CWMetricsPublisher;
import com.github.diegopacheco.cw.custom.metrics.MetricsPublisher;
import com.github.diegopacheco.cw.custom.metrics.TagManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main{
  public static void main(String args[]){

    TagManager.enableTestMode();

    Map<String, String> tags = new HashMap<String, String>()
    {{
      put("id", UUID.randomUUID().toString());
      put("tier", "Backend");
      put("owner", "team-1234");
    }};

    MetricsPublisher mp = new CWMetricsPublisher();
    mp.publish("test1",43D,tags);
    mp.publish("test2",43D,tags);
    System.out.println("done");
  }
}
