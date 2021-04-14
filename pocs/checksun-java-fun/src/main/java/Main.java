import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Main{

  public static void main(String args[]){
    byte[] a = "test".getBytes(StandardCharsets.UTF_8);
    byte[] b = "test".getBytes(StandardCharsets.UTF_8);
    byte[] c = "test.".getBytes(StandardCharsets.UTF_8);

    System.out.println("Checksum a == " + getCRC32Checksum(a));
    System.out.println("Checksum b == " + getCRC32Checksum(b));
    System.out.println("Checksum c == " + getCRC32Checksum(c));
  }

  public static long getCRC32Checksum(byte[] bytes) {
    Checksum crc32 = new CRC32();
    crc32.update(bytes, 0, bytes.length);
    return crc32.getValue();
  }

}
