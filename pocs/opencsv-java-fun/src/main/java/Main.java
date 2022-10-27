import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Main{
  public static void main(String args[]) throws Exception{

    String path = new File(".").getPath() + "/src/main/resources/";
    try (CSVReader reader = new CSVReader(new FileReader(path+"cities.csv"))) {
      List<String[]> r = reader.readAll();
      r.forEach(x -> System.out.println(Arrays.toString(x)));
    }

  }
}
