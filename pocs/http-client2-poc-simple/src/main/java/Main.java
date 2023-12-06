import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *  Outputs:
 *
 *  Download done.
 *  Files in the zip:
 *    => uscities.csv
 *    => uscities.xlsx
 *
 * */
public class Main {
    public static void main(String args[]) {
        httpClientV2CallZip();
        readZipInmemory();
    }

    private static void readZipInmemory() {
        System.out.println("Files in the zip: ");
        ZipArchiveInputStream zip = null;
        try {
            zip = new ZipArchiveInputStream(new FileInputStream("cities.zip"));
            ZipArchiveEntry entry = zip.getNextEntry();
            while (entry != null) {
                entry = zip.getNextEntry();
                if (entry!=null)
                    System.out.println(" => " + entry);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                zip.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void httpClientV2CallZip() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://simplemaps.com/static/data/us-cities/1.77/" +
                "basic/simplemaps_uscities_basicv1.77.zip");
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream inputStream = entity.getContent();
                     FileOutputStream fileOutputStream = new FileOutputStream("cities.zip")) {
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
            System.out.println("download done.");
        }
    }

}
