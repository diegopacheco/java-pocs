public class Printer {
    public static void print(String val){
        System.setProperty("U",val);
        System.out.println("Universe is[" + val + "] == " + System.getProperty("U"));
    }
}
