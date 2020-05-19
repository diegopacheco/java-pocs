import java.util.Optional;

public class FormatterBuilder {

    public static final Formatter EMPTY = new EmptyFormatter();

    public static Optional<Formatter> build(String name){
        if (name.equals("up")){
            return Optional.ofNullable(new UppercaseFormatter());
        }else if (name.equals("down")){
            return Optional.ofNullable(new LowercaseFormatter());
        }
        return Optional.ofNullable(EMPTY);
    }
}
