import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       System.out.println("Hello World");     
       System.out.println(isOdd(24));
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }
    
    public static List<String> genearteTenNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            names.add(generateName());
        }
        return names;
    }

    private static String generateName() {
        return "Name" + Math.random();
    }
   

}
