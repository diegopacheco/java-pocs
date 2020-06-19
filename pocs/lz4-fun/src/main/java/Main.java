import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

public class Main{
  public static void main(String args[]) throws Exception{

    LZ4Factory factory = LZ4Factory.fastestInstance();
    byte[] data = "This is a Lz4 Data, lets see if works? right! This is ok 1234567. ".getBytes("UTF-8");
    System.out.println("Original Data length : " + data.length);
    System.out.println("Original Data        : " + new String(data,"UTF-8"));

    LZ4Compressor compressor = factory.fastCompressor();
    int maxCompressedLength = compressor.maxCompressedLength(data.length);
    byte[] compressed = new byte[maxCompressedLength];
    int compressedLength = compressor.compress(data, 0, data.length, compressed, 0, maxCompressedLength);

    System.out.println("LZ4 Compressed Length: " + compressedLength);
    System.out.println("Lz4 Compressed Msg   : " + new String(compressed,"UTF-8"));

    LZ4FastDecompressor decompressor = factory.fastDecompressor();
    byte[] restored = new byte[data.length];
    int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, data.length);

    System.out.println("Lz4 Decompressed Length: " + compressedLength2);
    System.out.println("Lz4 Decompressed Msg   : " + new String(restored,"UTF-8"));

  }
}
