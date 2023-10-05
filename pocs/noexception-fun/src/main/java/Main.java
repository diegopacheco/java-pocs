import com.machinezoo.noexception.Exceptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Main{
  public static void main(String args[]){
    System.out.println(
        Exceptions.silence().get(() -> "test".substring(5)).orElse("fallback")
    );

    String test = null;
    Exceptions.silence().run(() -> System.out.println("This is a " + test));

    final List<String> lines = Exceptions.silence()
      .get(Exceptions.sneak().supplier(() -> Files.readAllLines(Path.of("test.txt"))))
      .orElse(Collections.emptyList());
    System.out.println(lines);
  }
}
