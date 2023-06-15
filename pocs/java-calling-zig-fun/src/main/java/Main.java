import jnr.ffi.LibraryLoader;
import java.io.File;

public class Main {

    public static class JavaAdd{
        public static int add(int a,int b){
            return a+b;
        }
    }

    public static interface ZigLib {
        int zig_add(int a,int b);
    }

    public static String getLibPath(){
        try{
            String libPath = new File(".").getCanonicalPath() + "/zig-add-lib/";
            return libPath;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]){
        String dylib = "libadd.so";
        ZigLib zlib = LibraryLoader.create(ZigLib.class).load(getLibPath()+dylib);
        System.out.println("Zig lib loaded. ");

        long start = System.nanoTime();
        int result = zlib.zig_add(30,40);
        long end = System.nanoTime();
        System.out.println("Result from Zig zig_add:  " + result);
        System.out.println("Call took : " + (end - start) + " ns");

        System.out.println("Calling Pure Java");
        start = System.nanoTime();
        result = JavaAdd.add(30, 40);
        end = System.nanoTime();
        System.out.println("Result from Java JavaAdd.add:  " + result);
        System.out.println("Call took : " + (end - start) + " ns");
    }

}
