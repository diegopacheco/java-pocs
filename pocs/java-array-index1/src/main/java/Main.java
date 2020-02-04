import java.util.ArrayList;
import java.util.List;

public class Main{
  public static void main(String args[]){

    List<String> arrayOne = new ArrayList<String>(){
      private static final long serialVersionUID = 1L;
      public String get(int index) {
        return super.get(index-1);
      }
    };

    arrayOne.add("1");
    arrayOne.add("2");
    arrayOne.add("3");

    System.out.println(arrayOne.get(1));
    System.out.println(arrayOne.get(2));
    System.out.println(arrayOne.get(3));

  }
}
