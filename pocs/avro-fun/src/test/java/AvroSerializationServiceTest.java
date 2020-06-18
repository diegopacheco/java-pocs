import com.github.diegopacheco.avro.AvroHttpRequest;
import com.github.diegopacheco.avro.PersonIdentifier;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AvroSerializationServiceTest {

    @Test
    public void testSerde(){

        AvroSerializationService ass = new AvroSerializationService();

        PersonIdentifier pi = PersonIdentifier.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setName("Diego Pacheco")
                .setEmail("diego.pacheco.it@gmail.com")
                .build();

        AvroHttpRequest req = AvroHttpRequest.newBuilder()
                .setPersonIdentifier(pi)
                .build();

        byte[] data = ass.serializeToBinary(req);
        assertTrue(Objects.nonNull(data));
        assertTrue(data.length > 0);

        AvroHttpRequest req2 = ass.deSerealizeFromBinary(data);
        assertEquals(req2, req);
        System.out.println(req);
        System.out.println(req2);
    }

}
