import io.nats.jparse.Json;
import io.nats.jparse.Path;
import io.nats.jparse.node.ArrayNode;
import io.nats.jparse.node.RootNode;
import io.nats.jparse.source.Sources;
import java.io.File;

public class Main{
  public static void main(String args[]){
    final File file = new File("./src/main/resources/data.json");
    final RootNode rootNode = Json.toRootNode(Sources.fileSource(file));
    System.out.println(rootNode);

    final ArrayNode engineeringEmployees =
            Path.atPath("departments[0].employees", rootNode).asCollection().asArray();
    System.out.println("      " + engineeringEmployees.toJsonString());
  }
}
