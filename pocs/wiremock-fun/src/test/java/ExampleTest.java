import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ExampleTest {

    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void setup(){
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
    }

    @AfterAll
    public static void tearDown(){
        wireMockServer.stop();
    }

    private static void call(String data){
        try {
            URL url = new URL("http://127.0.0.1:8080/my/resource/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/xml");
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                wr.write(data.getBytes());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void exampleTest() {
        // Setup what is expected(mocked) and what will be returned.
        stubFor(post(urlEqualTo("/my/resource/"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

        // simulate service - real call
        call("<message>1234</message>");

        // verify if was called or not
        verify(postRequestedFor(urlMatching("/my/resource/"))
                .withRequestBody(matching(".*<message>1234</message>.*"))
                .withHeader("Content-Type", notMatching("text/xml")));
    }

}
