import java.util.Optional;

public class FormatterFactory {

    public static Optional<Formatter> getPrinter(String name){
        Optional<Formatter> printer = Optional.empty();
        switch (name.toLowerCase()){
            case "lower":
                printer = Optional.ofNullable(new LowercaseFormatter());
            break;
            case "upper":
                printer = Optional.ofNullable((new Uppercaseformatter()));
            break;
            default:
        }
        return printer;
    }
}
