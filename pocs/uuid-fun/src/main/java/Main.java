import com.github.diegopacheco.javapocs.uuid.UUIDUtils;

public class Main{
  public static void main(String args[]){
    System.out.println("UUID method 1 " + UUIDUtils.uuidMethod1());
    System.out.println("UUID method 2 " + UUIDUtils.uuidMethod2());
    System.out.println("UUID TS       " + UUIDUtils.generateTimeBasedUUID().timestamp());
    System.out.println("UUID TS       " + UUIDUtils.getDatefromUUID(UUIDUtils.generateTimeBasedUUID()));
  }
}
