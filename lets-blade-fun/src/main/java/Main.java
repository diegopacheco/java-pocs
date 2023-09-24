import com.hellokaton.blade.Blade;
import com.hellokaton.blade.options.CorsOptions;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Blade.create()
                .faviconDir( new File(".").getCanonicalPath() + "/src/main/resources/")
                .get("/", ctx -> ctx.text("Hello Blade"))
                .start();
    }
}
