import java.util.Arrays;
import java.util.List;

public class Main {

    List<String> values = Arrays.asList("hi");

    public static void main(String args[]) {
        Main m = new Main();    
        System.out.println("From Main app - It works!");

        for (int i = 0; i < args.length; i++) {
            final String arg = args[i];
            Thread thread = new Thread("[Thread-" + arg + "]") {
                public void run() {
                    System.out.println("From Thread: " + Thread.currentThread().getName() + " arg: " + arg);
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (true) {
            try {
                m.print();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void print() {
        try {
            values.forEach(System.out::println);
            Thread.sleep(2000L);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add(String s) {
        System.out.println("added value " + s);
        values.add(s);
    }

}