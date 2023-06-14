import jnr.ffi.LibraryLoader;
import java.io.File;

public class Main {

    public static class JavaDouble{
        public static int it(int i){
            return i*2;
        }
    }

    public static interface RustLib {
        int double_input(int i);
    }

    public static String getLibPath(){
        try{
            String libPath = new File(".").getCanonicalPath() + "/doublelib/target/release/";
            return libPath;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]){
        String dylib = "libdoublelib.so";
        RustLib rlib = LibraryLoader.create(RustLib.class).load(getLibPath()+dylib);
        System.out.println("Rust lib loaded. ");

        long start = System.nanoTime();
        int result = rlib.double_input(30);
        long end = System.nanoTime();
        System.out.println("Result from rust double_input:  " + result);
        System.out.println("Call took : " + (end - start) + " ns");

        System.out.println("Calling Pure Java");
        start = System.nanoTime();
        result = JavaDouble.it(30);
        end = System.nanoTime();
        System.out.println("Result from Java JavaDouble.it:  " + result);
        System.out.println("Call took : " + (end - start) + " ns");
    }

}
