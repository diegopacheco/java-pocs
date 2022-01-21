import jodd.props.Props;
import java.io.File;

public class Main {
    public static void main(String args[]) {
        Props p = new Props();
        try {
            p.load(new File(new File(".").getCanonicalPath() + "/src/main/resources/config.props"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String age = p.getValue("users.data.age");
        System.out.println(age);

        String url = p.getValue("db.url", "develop");
        System.out.println(url);
    }
}
