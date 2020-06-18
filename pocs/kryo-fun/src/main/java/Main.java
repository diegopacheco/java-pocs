import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

public class Main{
  public static void main(String args[]) throws Exception {

      Person p = new Person();
      p.setName("Diego Pacheco");
      p.setEmail("diego.pacheco.it@gmail.com");
      p.setId(UUID.randomUUID().toString());

      Kryo kryo = new Kryo();
      Output output = new Output(new FileOutputStream(  "person-kryo.dat"));
      Input input  = new Input(new FileInputStream("person-kryo.dat"));

      kryo.writeObject(output, p);
      output.close();

      Person p2 = kryo.readObject(input, Person.class);
      input.close();

      System.out.println(p2);
  }
}
