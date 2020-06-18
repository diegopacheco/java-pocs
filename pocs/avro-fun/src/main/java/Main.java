import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.compiler.specific.SpecificCompiler;

import java.io.File;

public class Main{
  public static void main(String args[]){
    generateSchema();
    compile();
    System.out.println("Schema Generated and Compilation Done.");
  }

  private static void compile() {
    try{
      SpecificCompiler compiler = new SpecificCompiler(new Schema.Parser().parse(new File("src/main/resources/avroHttpRequest-schema.avsc")));
      compiler.compileToDestination(new File("src/main/resources"), new File("src/main/java"));
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static void generateSchema(){
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
