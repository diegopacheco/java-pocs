import com.sun.javafx.binding.Logging;

import java.util.ArrayList;

public class ShowCL {
    public static void printCL() {
        System.out.println("Classloader of this class:" + Main.class.getClassLoader());
        System.out.println("Classloader of Logging:" + Logging.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
    }
}
