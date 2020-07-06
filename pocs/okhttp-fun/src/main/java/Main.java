import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main{
  public static void main(String args[]) {
    OkHttpClient client = new OkHttpClient();
    System.out.println(run(client,"http://google.com.br/"));
  }

  public static String run(OkHttpClient client,String url){
    try{
      Request request = new Request.Builder()
              .url(url)
              .build();
      try (Response response = client.newCall(request).execute()) {
        return response.body().string();
      }
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
