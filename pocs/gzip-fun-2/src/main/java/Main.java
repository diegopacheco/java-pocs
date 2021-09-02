import com.github.diegopacheco.gzip.GZIPService;

import java.nio.charset.StandardCharsets;

public class Main{
  public static void main(String args[]){
    String str = "this is german utf8 stuff -> Entwickeln Sie mit Vergnügen!"; // 58 chars
    System.out.println("after compress:");
    String compressed = GZIPService.compress(str, StandardCharsets.UTF_8.name(),StandardCharsets.UTF_8.name());
    System.out.println(compressed);
    System.out.println("after decompress:");
    String decomp = GZIPService.decompress(compressed,StandardCharsets.UTF_8.name(),StandardCharsets.UTF_8.name());
    System.out.println(decomp);
  }
}
