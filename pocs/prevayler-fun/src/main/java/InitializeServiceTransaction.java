import java.util.Date;

import org.prevayler.Transaction;

public class InitializeServiceTransaction implements Transaction<Root> {

  private static final long serialVersionUID = 1L;

  public void executeOn(Root root, Date executionTime) {
    root.setCreated(executionTime.getTime());
  }

}