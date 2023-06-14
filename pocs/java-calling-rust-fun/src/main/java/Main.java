import jnr.ffi.LibraryLoader;
import java.io.File;

public class Main {

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
        int result = rlib.double_input(30);
        System.out.println("Result from rust double_input:  " + result);
    }

}
