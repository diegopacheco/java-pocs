public class Main {
    public static void main(String args[]) {
        System.out.println("From Main app - It works!");

        for (int i = 0; i < args.length; i++) {
            final String arg = args[i];
            Thread thread = new Thread("[Thread-"+arg+"]") {
                public void run() {
                    System.out.println("From Thread: " +
                            Thread.currentThread().getName() + " arg: " + arg);
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
