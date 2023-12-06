import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String args[]) {

    }

    private void httpClientV2CallZip() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.example.com/file.zip");
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream inputStream = entity.getContent();
                     FileOutputStream fileOutputStream = new FileOutputStream("file.zip")) {
                    int read;
                    byte[] buffer = new byte[4096];
                    while ((read = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, read);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("done.");
        }
    }

}
