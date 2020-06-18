import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

public class Main{
  public static void main(String args[]){

    Schema personIdentifier = SchemaBuilder.record("PersonIdentifier")
            .namespace("com.github.diegopacheco.avro")
            .fields()
            .requiredString("id")
            .requiredString("name")
            .requiredString("email")
            .endRecord();

    Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest")
            .namespace("com.github.diegopacheco.avro")
            .fields()
            .name("personIdentifier")
            .type(personIdentifier)
            .noDefault()
            .endRecord();
    System.out.println(avroHttpRequest.toString());
  }
}
