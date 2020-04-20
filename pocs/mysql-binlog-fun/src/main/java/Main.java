import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import com.github.shyiko.mysql.binlog.BinaryLogClient.EventListener;

public class Main {
  public static void main(String args[]){
    try{
      BinaryLogClient client = new BinaryLogClient("172.17.0.2", 3306, "root", "root");
      EventDeserializer eventDeserializer = new EventDeserializer();
      eventDeserializer.setCompatibilityMode(
          EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
          EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
      );
      client.setEventDeserializer(eventDeserializer);
      client.registerEventListener(new EventListener(){
        @Override
        public void onEvent(Event event) {
          System.out.println("Got an Event:" + event);
        }
      }); 
      client.connect();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
