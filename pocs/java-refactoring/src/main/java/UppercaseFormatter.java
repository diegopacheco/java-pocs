public class UppercaseFormatter implements Formatter{
    @Override
    public String format(String message) {
        return  (null==message || "".equals(message)) ? "" : message.toUpperCase();
    }
}
