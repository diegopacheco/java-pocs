
public class Main{
  public static void main(String args[]){
    System.out.println("2,8 max = " + max(2,8));
    System.out.println("-1,7 max = " + max(-1,7));
    System.out.println("4521,214 max = " + max(4521,214));
  }

  private static int max(int a,int b){
      int max = a-((a-b)&((a-b)>>31));
      return max;
  }

}
