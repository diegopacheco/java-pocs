import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.pipeline.Pipeline;
import com.hazelcast.jet.pipeline.Sinks;
import com.hazelcast.jet.pipeline.test.TestSources;

public class Main{
  public static void main(String args[]){
    Pipeline p = Pipeline.create();
    p.readFrom(TestSources.itemStream(10))
            .withoutTimestamps()
            .filter(event -> event.sequence() % 2 == 0)
            .setName("filter out odd numbers")
            .writeTo(Sinks.logger());

    JetInstance jet = Jet.newJetInstance();
    jet.newJob(p).join();
  }
}
