import java.io.Serializable;

public class ProperSingleton implements Serializable {

    private volatile static ProperSingleton INSTANCE;

    private ProperSingleton(){
        if (null!=INSTANCE){
            // Make Reflection Proof.
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ProperSingleton getInstance(){
        if (null==INSTANCE){
            // Make Lazy and Thread Safe Proof.
            synchronized (ProperSingleton.class){
                if (null==INSTANCE){
                    INSTANCE=new ProperSingleton();
                }
            }
        }
        return INSTANCE;
    }

    // Make Serialization Proof.
    protected ProperSingleton readResolve() {
        return getInstance();
    }

}
