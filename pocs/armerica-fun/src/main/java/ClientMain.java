import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.common.AggregatedHttpResponse;

public class ClientMain{
    public static void main(String[] args) throws Exception {
        WebClient webClient = WebClient.of("http://127.0.0.1:8080/");
        AggregatedHttpResponse res1 = webClient.get("/").aggregate().join();
        System.out.println("Result from Server : " + res1.contentUtf8());

        AggregatedHttpResponse res2 = webClient.get("/hello/DiegoPacheco").aggregate().join();
        System.out.println("Result from Server : " + res2.contentUtf8());
    }
}

