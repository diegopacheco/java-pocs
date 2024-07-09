import com.github.diegopacheco.java21.futy.pojo.Person;
import com.github.diegopacheco.java21.futy.service.SerializationService;

import java.util.UUID;

public class Main{
  public static void main(String args[]){
    Person person = new Person(UUID.randomUUID(),"JohnDoe","jd@jd.jd");
    SerializationService ss = new SerializationService();
    byte[] ser = ss.serialize(person);
    System.out.println("Serialized    : " + ser);
    System.out.println("Serialized len: " + ser.length);

    Person p = ss.deserialize(ser, Person.class);
    System.out.println(p);
  }
}
