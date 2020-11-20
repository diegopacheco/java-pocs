import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.github.diegopacheco.astra.dao.InventoryMapper;
import com.github.diegopacheco.astra.dao.InventoryMapperBuilder;
import com.github.diegopacheco.astra.dao.ProductDao;
import com.github.diegopacheco.astra.entity.Product;
import com.github.diegopacheco.astra.schema.SchemaManager;
import com.github.diegopacheco.astra.session.SessionManager;

import java.util.UUID;

public class Main{
  public static void main(String args[]){

    try(CqlSession session = SessionManager.getSession()){

      SchemaManager.create();

      InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();
      ProductDao dao = inventoryMapper.productDao(CqlIdentifier.fromCql("test"));

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
