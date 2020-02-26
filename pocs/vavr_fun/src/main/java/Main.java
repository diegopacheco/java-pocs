import io.vavr.collection.List;
import io.vavr.collection.Queue;

public class Main {
  public static void main(String args[]){

    List<Integer> list1 = List.of(1, 2, 3);
    System.out.println(list1);
    
    Queue<Integer> queue = Queue.of(1, 2, 3)
                            .enqueue(4)
                            .enqueue(5);
    System.out.println(queue);                        

  }
}
