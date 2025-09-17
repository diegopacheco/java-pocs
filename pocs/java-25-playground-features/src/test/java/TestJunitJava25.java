import org.junit.jupiter.api.Test;

public class TestJunitJava25 {

    @Test
    public void checkJavais25(){
        String version = System.getProperty("java.version");
        assert(version.startsWith("25"));
    }

}
