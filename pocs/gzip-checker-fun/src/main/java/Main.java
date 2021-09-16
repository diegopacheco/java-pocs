import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String args[]) throws Exception {

        String strData = "<xml>test</xml>";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gzipOutputStream.write(strData.getBytes());
        gzipOutputStream.close();

        print(byteArrayOutputStream, StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1.name());
        print(byteArrayOutputStream, StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8.name());
        print(byteArrayOutputStream, StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII.name());
        print(byteArrayOutputStream, StandardCharsets.ISO_8859_1.name(), StandardCharsets.UTF_8.name());
        print(byteArrayOutputStream, StandardCharsets.UTF_8.name(), StandardCharsets.ISO_8859_1.name());

    }

    private static void print(ByteArrayOutputStream byteArrayOutputStream,
                              String toStringEncoding,
                              String getBytesEncoding
    ) throws Exception {
        String data = byteArrayOutputStream.toString(toStringEncoding);
        byte[] bytes = data.getBytes(getBytesEncoding);
        for (int i = 0; i <= 15; i++) {
            System.out.print(String.format("%02X ", bytes[i]));
        }
        System.out.print(" valid gzip? " + String.format("%5s", isValidGZip(bytes)) + " -" +
                " toStringEncoding: " + String.format("%10s", toStringEncoding) +
                " getBytesEncoding: " + String.format("%10s", getBytesEncoding));
        System.out.print(" can decompress? " + canDecompress(new String(bytes,getBytesEncoding),getBytesEncoding));
        System.out.println("");
    }

    private static boolean isValidGZip(byte[] bytes) {
        if ((bytes == null) || (bytes.length < 2)) {
            return false;
        } else {
            return ((bytes[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (bytes[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8)));
        }
    }

    private static boolean canDecompress(String source,String getBytesEncoding) {
        if (source == null || source.length() == 0) {
            return false;
        }
        try {
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(source.getBytes(getBytesEncoding)));
            BufferedReader bf = new BufferedReader(new InputStreamReader(gis));
            String outStr = "";
            String line;
            while ((line = bf.readLine()) != null) {
                outStr += line;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

   /*
   // works as the same as isValidGZip - so not needed
   public static boolean isGzipStream(byte[] bytes) {
    int head = ((int) bytes[0] & 0xff) | ((bytes[1] << 8) & 0xff00);
    return (GZIPInputStream.GZIP_MAGIC == head);
   }
   */

}
