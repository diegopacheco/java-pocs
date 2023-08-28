import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        methodReflection();
        fieldReflection();
        constructorReflection();
    }

    private static void constructorReflection() {
        ConstructorAccess<Bear> access = ConstructorAccess.get(Bear.class);
        Bear someObject = access.newInstance();
        System.out.println(someObject);
    }

    private static void fieldReflection() {
        Bear someObject = new Bear("Black",7);
        FieldAccess access = FieldAccess.get(Bear.class);
        access.set(someObject, "color", "Brown");
        String value = (String)access.get(someObject, "color");
        System.out.println(value);
    }

    private static void methodReflection() {
        ArrayList<String> someObject = new ArrayList<String>();
        MethodAccess access = MethodAccess.get(ArrayList.class);
        access.invoke(someObject, "add", "Awesome Reflection");
        String name = (String) access.invoke(someObject, "get", 0);
        System.out.println(name);
    }
}
