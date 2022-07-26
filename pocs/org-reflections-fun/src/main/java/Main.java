import org.reflections.Reflections;

import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class Main{
  public static void main(String args[]){

    long init = System.currentTimeMillis();
    Reflections reflections = new Reflections("com.github.diegopacheco");

    Set<Class<?>> annotated =
            reflections.get(
                  SubTypes.of(
                          TypesAnnotated
                                  .with(Deprecated.class))
                          .asClass());

    System.out.println(annotated);

    long end = System.currentTimeMillis();
    System.out.println("Reflections in: " + (end-init) + " ms");
  }
}
