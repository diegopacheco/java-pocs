import org.bouncycastle.util.io.Streams;
import java.io.*;

public class Main{
  public static void main(String args[]) throws Exception{
    long init = System.currentTimeMillis();

    InputStream is = new FileInputStream(new File("/tmp/in.txt"));
    OutputStream out = new FileOutputStream("/tmp/out.txt");
    Streams.pipeAll(is, out);

    long end = System.currentTimeMillis();
    System.out.println("Copy done in " + (end-init) + " ms.");

  }
}
