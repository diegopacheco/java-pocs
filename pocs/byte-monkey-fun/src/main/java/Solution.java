import java.util.Date;

public class Solution {

    private Date getDate(int luckyNumber, String yourName) throws SomethingOpsHappenedException {
        System.out.println("returning date for [" + luckyNumber + "] [" + yourName + "]");
        return new Date();
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Getting date " + getDate(7, "java"));
                Thread.sleep(1000L);
            } catch (Throwable t) {
                System.out.println(t);
            }
        }
    }

}
