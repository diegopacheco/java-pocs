import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main{
  public static void main(String args[])throws Exception{
    String base = new File(".").getCanonicalPath() + "/";
    String file = base + "myfile.txt";
    String gzipFile = file + ".gz";
    String newFile  = file + ".new.txt";

    compressGzipFile(file, gzipFile);
    decompressGzipFile(gzipFile, newFile);
  }

  private static void decompressGzipFile(String gzipFile, String newFile) {
    try {
      FileInputStream fis = new FileInputStream(gzipFile);
      GZIPInputStream gis = new GZIPInputStream(fis);
      FileOutputStream fos = new FileOutputStream(newFile);
      byte[] buffer = new byte[1024];
      int len;
      while((len = gis.read(buffer)) != -1){
        fos.write(buffer, 0, len);
      }
      //close resources
      fos.close();
      gis.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  private static void compressGzipFile(String file, String gzipFile) {
    try {
      FileInputStream fis = new FileInputStream(file);
      FileOutputStream fos = new FileOutputStream(gzipFile);
      GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
      byte[] buffer = new byte[1024];
      int len;
      while((len=fis.read(buffer)) != -1){
        gzipOS.write(buffer, 0, len);
      }
      //close resources
      gzipOS.close();
      fos.close();
      fis.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

}