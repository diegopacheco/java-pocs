import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {

    public static void main(String args[]) throws Exception {
        System.out.println("Whats is my IP? " + run("http://ipecho.net/plain"));
    }

    private static String run(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
