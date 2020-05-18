public class LowercaseFormatter implements Formatter{
    @Override
    public String format(String msg) {
        return (null==msg || "".equals(msg)) ? "" : msg.toLowerCase();
    }
}
