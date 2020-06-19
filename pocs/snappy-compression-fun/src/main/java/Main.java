import org.xerial.snappy.Snappy;

public class Main{
  public static void main(String args[])throws Exception{

    String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of "
                 + "Snappy, a fast compresser/decompresser. okay?";

    byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
    byte[] uncompressed = Snappy.uncompress(compressed);

    String result = new String(uncompressed, "UTF-8");
    System.out.println("Compress/Decompress : " + result);
    System.out.println("Size Uncompressed: " + uncompressed.length + " Size Compressed: " + compressed.length);
    System.out.println("Compressed msg: ");
    System.out.println(new String(compressed,"UTF-8"));
    System.out.println("String Compressed and back msg: ");
    System.out.println(new String( Snappy.uncompress(new String(compressed,"UTF-8").getBytes("UTF-8")) ,"UTF-8"));
  }
}
