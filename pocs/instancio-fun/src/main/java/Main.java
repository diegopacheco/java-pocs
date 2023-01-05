import com.github.diegopacheco.javapocs.model.Order;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.List;

import static org.instancio.Select.field;

public class Main{
  public static void main(String args[]){

    List<Order> orders = Instancio.ofList(Order.class).size(10).create();
    orders.forEach( o -> System.out.println(o));

    Model<Order> baseOrder = Instancio.of(Order.class)
            .set(field("productName"), "Sweet Gum")
            .generate(field("quantity"), gen -> gen.ints().range(1, 100 ))
            .toModel();

    Order orderOne = Instancio.of(baseOrder)
            .set(field("customerName"), "Homer")
            .create();
    System.out.println("\n" + orderOne);
  }
}
