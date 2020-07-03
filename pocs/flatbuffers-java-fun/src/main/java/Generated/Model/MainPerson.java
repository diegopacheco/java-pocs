package Generated.Model;

import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;
import java.util.UUID;

public class MainPerson {
    public static void main(String[] args) {
        FlatBufferBuilder builder = new FlatBufferBuilder(0);
        int id = builder.createString(UUID.randomUUID().toString());
        int name = builder.createString("Diego");
        int email = builder.createString("diego.pacheco.it@gmail.com");

        Person.startPerson(builder);
        Person.addId(builder,id);
        Person.addName(builder,name);
        Person.addEmail(builder,email);
        int person = Person.endPerson(builder);
        builder.finish(person);

        for(int i=0;i<100;i++){
            Person.getRootAsPerson(builder.dataBuffer());
        }

        long start = System.nanoTime();
        ByteBuffer buf = builder.dataBuffer();
        long end  = System.nanoTime();
        System.out.println("Serilize time: " + (end-start) + " ms - size: " + buf.array().length);
        System.out.println(person);

        start = System.nanoTime();
        Person p2 = Person.getRootAsPerson(buf);
        end  = System.nanoTime();
        System.out.println("Deserilize time: " + (end-start) + " ms");
        System.out.println(p2.toString());

        /**
         * Serilize time: 507 ms - size: 128
         * Deserilize time: 5922 ms
         */
    }
}

