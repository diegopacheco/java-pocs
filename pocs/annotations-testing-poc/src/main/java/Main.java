import com.github.diegopacheco.java.pocs.annotations.Owner;
import com.github.diegopacheco.java.pocs.reader.AnnotationReader;
import java.util.Set;

public class Main{
  public static void main(String args[]){
    System.out.println("Check it all. ");
    Set<Class> clazzes = AnnotationReader.findAllClasses("com.github.diegopacheco.java.pocs.catalog", Owner.class);
    for(Class c : clazzes){
      String value = AnnotationReader.getAnnotationValue(c, Owner.class,"email");
      if (!value.equals("dev@dev.com")){
        System.out.println(" * not default email -> " + value);
      }
    }
    System.out.println("DONE.");
  }
}