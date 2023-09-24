import com.hellokaton.blade.Blade;

public class Main {
    public static void main(String[] args) {
        Blade.create().get("/", ctx -> ctx.text("Hello Blade")).start();
    }
}
