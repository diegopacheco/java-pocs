public class Bench {

    public static long with(Runnable code,String message){
        System.out.println(message);
        long init = System.currentTimeMillis();
        code.run();
        long end = System.currentTimeMillis();
        System.out.println("Run in " + (end-init) + " ms");
        return (end-init);
    }

}
