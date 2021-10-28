import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String> values = Arrays.asList("hi");

    public static void main(String args[]) {
        System.out.println("From Main app - It works!");

        for (int i = 0; i < args.length; i++) {
            final String arg = args[i];
            Thread thread = new Thread("[Thread-"+arg+"]") {
                public void run() {
                    System.out.println("From Thread: " +
                            Thread.currentThread().getName() + " arg: " + arg);
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while(true){
            try{
                values.forEach(System.out::println);
                Thread.sleep(2000L);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void add(String s){
        System.out.println("added value " + s);
        values.add(s);
    }

}