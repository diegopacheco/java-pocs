import com.github.diegopacheco.javapocs.es.driver.Document;
import com.github.diegopacheco.javapocs.es.driver.ESDriver;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;

public class Main{
  public static void main(String args[]){
    ESDriver driver = new ESDriver();
    driver.prepareIndexBeforeFeeder("posts");

    Document doc1 = new Document();
    doc1.setId("1");
    doc1.setIndex("posts");
    String jsonString = "{" +
            "\"user\":\"kimchy\"," +
            "\"postDate\":\"2013-01-30\"," +
            "\"message\":\"trying out Elasticsearch\"" +
            "}";
    doc1.setContent(jsonString);
    IndexResponse responde = driver.index(doc1);
    System.out.println(responde);
    System.out.println(responde.status());

    Document doc2 = new Document();
    doc2.setId("2");
    doc2.setIndex("posts");
    jsonString = "{" +
            "\"user\":\"kimchy Jr\"," +
            "\"postDate\":\"2013-01-30\"," +
            "\"message\":\"trying out Elasticsearch\"" +
            "}";
    doc2.setContent(jsonString);
    responde = driver.index(doc2);
    System.out.println(responde);
    System.out.println(responde.status());

    Document doc3 = new Document();
    doc3.setId("3");
    doc3.setIndex("posts");
    jsonString = "{" +
            "\"user\":\"John Doe\"," +
            "\"postDate\":\"2013-01-30\"," +
            "\"message\":\"trying out Elasticsearch\"" +
            "}";
    doc3.setContent(jsonString);
    responde = driver.index(doc3);
    System.out.println(responde);
    System.out.println(responde.status());

    GetResponse response = driver.get("posts","1");
    System.out.println(response);
    System.out.println(response.getFields());
    System.out.println(response.getSource());

    MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user", "kimchy");
    matchQueryBuilder.fuzziness(Fuzziness.AUTO);
    matchQueryBuilder.prefixLength(10);
    matchQueryBuilder.maxExpansions(10);
    SearchResponse sr = driver.search("posts",matchQueryBuilder);
    System.out.println(sr);
    System.out.println(sr.status());
    System.out.println(sr.getTook());

    SearchHit[] hits = sr.getHits().getHits();
    System.out.println("Search Result Count " + hits.length);
    for(int i=0;i<hits.length;i++){
      SearchHit sh = hits[i];
      System.out.println(sh);
    }

  }
}
