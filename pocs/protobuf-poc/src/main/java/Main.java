import com.github.diegopacheco.protobuf.protos.PersonProto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class Main{
  public static void main(String args[]) throws Exception {
    PersonProto.Person person = PersonProto.Person.newBuilder()
            .setId(UUID.randomUUID().toString())
            .setEmail("diego.pacheco.it@gmail.com")
            .setName("Diego Pacheco")
            .build();
    System.out.println(person);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    person.writeTo(out);

    ByteArrayInputStream input = new ByteArrayInputStream(out.toByteArray());
    PersonProto.Person p2 = PersonProto.Person.newBuilder().mergeFrom(input).build();
    System.out.println(p2);
  }
}
