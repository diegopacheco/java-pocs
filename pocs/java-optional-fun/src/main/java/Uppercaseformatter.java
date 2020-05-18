public class Uppercaseformatter implements Formatter{
    @Override
    public String format(String msg) {
        return (null==msg || "".equals(msg)) ? "" : msg.toUpperCase();
    }
}
