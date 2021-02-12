import com.github.diegopacheco.scannotations.annotations.core.AnnotationsDiscovery;

import java.util.stream.Collectors;

public class Main{
  public static void main(String args[]){
    System.out.println(
            AnnotationsDiscovery.getPrintables().
                    stream().
                    map( p-> p.getClass().getName()).
                    collect(Collectors.toSet())
    );
    System.out.println("It works! @Printable == " + AnnotationsDiscovery.getPrintables().size());
  }
}
