import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main{
  static public void main (String[] args) throws Exception {
    Kryo kryo = new Kryo();
    kryo.register(SomeClass.class);

    SomeClass object = new SomeClass();
    object.value = "Hello Kryo!";

    Output output = new Output(new FileOutputStream("file.bin"));
    kryo.writeObject(output, object);
    output.close();

    Input input = new Input(new FileInputStream("file.bin"));
    SomeClass object2 = kryo.readObject(input, SomeClass.class);
    input.close();
    System.out.println(object2.value);
  }
  static public class SomeClass {
    String value;
  }
}
