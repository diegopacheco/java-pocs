import java.util.function.Function;
import java.util.function.Supplier;

public class Lazy<T> {

    private T value;
    private final Function<Lazy<T>,T> function;

    public Lazy(Function<Lazy<T>, T> function) {
        this.function = function;
    }

    public Lazy(Supplier<T> supplier) {
        this( __ -> supplier.get() );
    }

    public T value(){
        if (null==value){
            value = function.apply(this);
        }
        return value;
    }

    public <R> Lazy<R> map(Function<T,R> function){
        return new Lazy<>( x-> function.apply(this.value()));
    }

    public <R> Lazy<R> flatMap(Function<T,Lazy<R>> function){
        return new Lazy<>( x-> function.apply(this.value()).value() );
    }

}
