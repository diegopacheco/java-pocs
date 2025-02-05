import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Element1");
        list.add("Element2");
        
        for (String element : list) {
            System.out.println(element);
        }
        list.add("Element3");

        for (String element : list) {
          System.out.println(element);
        }
    }
}