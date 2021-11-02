
public class SomethingOpsHappenedException extends RuntimeException {

    public SomethingOpsHappenedException(){}

    public SomethingOpsHappenedException(String message){
        super(message);
    }

    public SomethingOpsHappenedException(String message, Exception root){
        super(message,root);
    }

}
