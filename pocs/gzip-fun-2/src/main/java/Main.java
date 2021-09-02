import com.github.diegopacheco.gzip.Base64GZIPService;
import com.github.diegopacheco.gzip.GZIPService;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main{
  public static void main(String args[]){

    try{
      b64Way();
    }catch(Exception e){
      e.printStackTrace();
    }

    try{
      stringWayISO();
    }catch(Exception e){
      e.printStackTrace();
    }

    try{
      stringWayUTF8();
    }catch(Exception e){
      e.printStackTrace();
    }

  }

  private static void stringWayUTF8(){
    System.out.println("stringWayUTF8 ======");
    System.out.println("Java Default charset is: " + Charset.defaultCharset().name());
    String str = "this is german utf8 stuff -> Entwickeln Sie mit Vergnügen!"; // 58 chars
    System.out.println("after compress:");
    String compressed = GZIPService.compress(str, StandardCharsets.UTF_8.name(),StandardCharsets.UTF_8.name());
    System.out.println(compressed);
    System.out.println("after decompress:");
    // blows as ZipException: Not in GZIP format
    String decomp = GZIPService.decompress(compressed,StandardCharsets.UTF_8.name());
    System.out.println(decomp);
  }

  private static void stringWayISO(){
    System.out.println("stringWayISO ======");
    System.out.println("Java Default charset is: " + Charset.defaultCharset().name());
    String str = "this is german utf8 stuff -> Entwickeln Sie mit Vergnügen!"; // 58 chars
    System.out.println("after compress:");
    String compressed = GZIPService.compress(str, StandardCharsets.ISO_8859_1.name(),StandardCharsets.ISO_8859_1.name());
    System.out.println(compressed);
    System.out.println("after decompress:");
    // blows as ZipException: Not in GZIP format
    String decomp = GZIPService.decompress(compressed,StandardCharsets.ISO_8859_1.name());
    System.out.println(decomp);
  }

  private static void b64Way(){
    System.out.println("Base64 WAY ======");
    System.out.println("Java Default charset is: " + Charset.defaultCharset().name());
    String str = "this is german utf8 stuff -> Entwickeln Sie mit Vergnügen!"; // 58 chars
    System.out.println("after compress:");
    String compressed = Base64GZIPService.compress(str, StandardCharsets.UTF_8.name(),StandardCharsets.UTF_8.name());
    System.out.println(compressed);
    System.out.println("after decompress:");
    // blows as ZipException: Not in GZIP format
    String decomp = Base64GZIPService.decompress(compressed,StandardCharsets.UTF_8.name(),StandardCharsets.UTF_8.name());
    System.out.println(decomp);
  }

}
