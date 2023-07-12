
public class Main{
  public static void main(String args[]){
    System.out.println("==== Sudo PII Detector Test ");
    System.out.println(">> 89506             = " + SudoPIIDetector.hasPII("89506"));
    System.out.println(">> john@doe.com.br   = " + SudoPIIDetector.hasPII("john@doe.com.br"));
    System.out.println(">> (456)122-5555     = " + SudoPIIDetector.hasPII("(456)122-5555"));
    System.out.println(">> 09-10-2002        = " + SudoPIIDetector.hasPII("09-10-2002"));
    System.out.println(">> John              = " + SudoPIIDetector.hasPII("John"));
    System.out.println(">> Jennifer          = " + SudoPIIDetector.hasPII("Jennifer"));
    System.out.println(">> Sbrubles          = " + SudoPIIDetector.hasPII("Sbrubles"));
    System.out.println(">> yes               = " + SudoPIIDetector.hasPII("yes"));
    System.out.println(">> no                = " + SudoPIIDetector.hasPII("no"));
    System.out.println(">> simple message    = " + SudoPIIDetector.hasPII("simple message"));
    System.out.println(">> 3rf3wergt45h5@    = " + SudoPIIDetector.hasPII("3rf3wergt45h5@"));
  }
}
