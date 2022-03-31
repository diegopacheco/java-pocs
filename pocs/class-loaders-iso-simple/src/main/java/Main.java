import com.github.diegopacheco.java.sandbox.cl.CustomClassLoader;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String args[]) {
        System.setProperty("U", "DC");
        System.out.println("Universe is: " + System.getProperty("U"));

        ExecutorService es = Executors.newFixedThreadPool(2);
        submit(es,"MCU");
        submit(es,"SpiderVerse");

    }

    private static void run(String val) {
        try {
            CustomClassLoader ccl = new CustomClassLoader();
            Class<?> clazz = ccl.loadClass(Printer.class.getName());
            Object printer = clazz.getDeclaredConstructors()[0].newInstance();
            Method print = clazz.getDeclaredMethod("print", String.class);
            print.invoke(printer, val);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void submit(ExecutorService es, String val) {
        try {
            es.submit(() -> {
                while (true) {
                    run(val);
                    Thread.sleep(1000L);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
