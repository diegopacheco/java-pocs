import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;

import java.util.UUID;

public class Main{
  public static void main(String args[]){
    try(CqlSession session = CqlSession.builder().build()){
      InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
      ProductDao dao = inventoryMapper.productDao(CqlIdentifier.fromCql("inventory"));

      UUID id = UUID.randomUUID();
      Product newProduct = new Product(id, "Mechanical keyboard");
      dao.save(newProduct);
      System.out.println("product created: " + newProduct);

      Product p = dao.findById(id);
      System.out.println("product found: " + p);

      dao.delete(p);
      System.out.println("product deleted: " + p);
    }
  }
}
