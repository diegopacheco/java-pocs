import org.pcollections.HashTreePSet;
import org.pcollections.PSet;

public class Main{
  public static void main(String args[]){
    PSet<String> set = HashTreePSet.empty();
    set = set.plus("something");
    System.out.println(set);
    System.out.println(set.plus("something else"));
    System.out.println(set);
  }
}
