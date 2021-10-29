import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       System.out.println("Hello World");     
       System.out.println(isOdd(24));
       System.out.println(isEven(24));
       System.out.println(generateTenRandomNames());
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }
    
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    private static List<String> generateTenRandomNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            names.add(generateRandomName());
        }
        return names;
    }

    private static String generateRandomName() {
        return "name" + Math.random();
    }

}
