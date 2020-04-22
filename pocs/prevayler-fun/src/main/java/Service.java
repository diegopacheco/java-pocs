import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;

public class Service {

  private static Service instance = new Service();
  private Prevayler<Root> prevayler;

  private Service() {}

  public static Service getInstance() {
    return instance;
  }

  public Prevayler<Root> getPrevayler() {
    return prevayler;
  }

  public void open(){
      try{
        prevayler = PrevaylerFactory.createPrevayler(new Root(), "PrevalenceBase");
        if (prevayler.prevalentSystem().getCreated() == null) {
          prevayler.execute(new InitializeServiceTransaction());
          prevayler.takeSnapshot();
        }
      }catch(Exception e){
          throw new RuntimeException(e);
      }
  }

  public void close(){
    try{
        prevayler.close();
    }catch(Exception e){
        throw new RuntimeException(e);
    }
  }

}