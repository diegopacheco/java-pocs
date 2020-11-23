import com.github.diegopacheco.pojos.PojoA;
import com.github.diegopacheco.pojos.PojoB;
import com.github.diegopacheco.pojos.PojoC;

import java.lang.reflect.Field;

public class Main{
  public static void main(String args[]) throws Exception{

    PojoA privateObject = new PojoA();
    Field privateStringField = PojoA.class.getDeclaredField("name");
    privateStringField.setAccessible(true);
    String fieldValue = (String) privateStringField.get(privateObject);
    System.out.println("fieldValue = " + fieldValue);

    Field privatePojoBField = PojoA.class.getDeclaredField("pojob");
    privatePojoBField.setAccessible(true);
    PojoB fieldValuePojoB = (PojoB) privatePojoBField.get(privateObject);
    System.out.println("fieldValue = " + fieldValuePojoB);

    Field privatePojoCField = PojoB.class.getDeclaredField("pojoc");
    privatePojoCField.setAccessible(true);
    PojoC fieldValuePojoC = (PojoC) privatePojoCField.get(fieldValuePojoB);
    System.out.println("fieldValue = " + fieldValuePojoC);

  }
}
