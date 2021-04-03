import com.github.diegopacheco.javapocs.pojo.Person;

import java.nio.charset.StandardCharsets;

public class Main{

  /**
    Serialization format    : AAAAe0RpZWdvMTIzNCBjZW50ZXIgc3RyZWV0Lg==
    Base64 Estimation       : 40
    object size in bytes    : 28
    Base 64 without padding : 38
    Base 64 padding count   : 2
    Serialization b64 size  : 40
    Pojo                    : Person{id=123, name='Diego', address=[B@3a71f4dd', address=1234 center street.}
   **/
  public static void main(String args[]){
    Person p = new Person();
    p.setId(123);
    p.setName("Diego");
    p.setAddress("1234 center street.".getBytes(StandardCharsets.UTF_8));
    String serialization = Person.toSerialization(p);

    System.out.println("Serialization format    : " + serialization);
    System.out.println("Base64 Estimation       : " + Person.estimateB64Size(Person.getObjectSize(p)));
    System.out.println("object size in bytes    : " + Person.getObjectSize(p));
    System.out.println("Base 64 without padding : " + Person.getB64SizeNoPadding(p));
    System.out.println("Base 64 padding count   : " + Person.getPadCount(serialization));
    System.out.println("Serialization b64 size  : " + serialization.length());

    Person backFromSer = Person.fromSerialization(serialization);
    System.out.println("Pojo                    : " + backFromSer);

  }
}
