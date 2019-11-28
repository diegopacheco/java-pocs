import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.common.AggregatedHttpResponse;
import com.linecorp.armeria.common.HttpHeaderNames;
import com.linecorp.armeria.common.HttpMethod;
import com.linecorp.armeria.common.RequestHeaders;

public class ClientMain{
    public static void main(String[] args) throws Exception {
        WebClient webClient = WebClient.of("http://example.com/");
 
        AggregatedHttpResponse res1 = webClient.get("/foo/bar.txt").aggregate().join();
        
        RequestHeaders getJson = RequestHeaders.of(HttpMethod.GET, "/foo/bar.json",
                                                HttpHeaderNames.ACCEPT, "application/json");
        
        AggregatedHttpResponse res2 = webClient.execute(getJson).aggregate().join();
        
        AggregatedHttpResponse res3 = webClient.post("/upload", "{ \"foo\": \"bar\" }")
                                            .aggregate().join();    
    }
}
