import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main{
  public static void main(String args[]) throws Exception {
    ProcessBuilder pb = new ProcessBuilder();
    pb.environment().put("MY_VAR", "Hello Folks");
    pb.command("/bin/bash", "-c", "echo $MY_VAR");
    Process process = pb.start();
    String result = read(process);
    System.out.println("Outcome 1: " + result);

    pb.command(new File(".").getCanonicalPath() + "/simple_script.sh");
    process = pb.start();
    result = read(process);
    System.out.println("Outcome2 : " + result);

    pb.command("cat",new File(".").getCanonicalPath() + "/simple_script.sh");
    process = pb.start();
    result = read(process);
    System.out.println("Outcome3 : " + result);
  }

  private static String read(Process process){
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      StringBuilder builder = new StringBuilder();
      String line = null;
      while ( (line = reader.readLine()) != null) {
        builder.append(line);
        builder.append(System.getProperty("line.separator"));
      }
      String result = builder.toString();
      return result;
    }catch (Exception e){
      throw new RuntimeException(e);
    }
  }

}
