import com.github.diegopacheco.javapocs.reclections.logger.Logger;
import com.github.diegopacheco.javapocs.reclections.logger.SimpleLogger;
import com.github.diegopacheco.javapocs.reclections.pojo.Person;

import java.util.Arrays;

public class Main{
  public static void main(String args[]){
    Logger log = new SimpleLogger();
    Person p = new Person("Diego","diego@diego.com",
            "1234 diego st",true, Arrays.asList("Java"));
    log.log(p);
    log.log("nothing different should happen here. ");
  }
}
