public class Main{
  public static void main(String args[]){
    String name="sonoo";
    String sf1=String.format("name is %s",name);
    String sf2=String.format("value is %f",32.33434);
    String sf3=String.format("value is %32.12f",32.33434);//returns 12 char fractional part filling with 0
    String str2 = String.format("|%10d|", 101);  // Specifying length of integer
    String str3 = String.format("|%-10d|", 101); // Left-justifying within the specified width
    String str5 = String.format("|%010d|", 101); // Filling with zeroes

    System.out.println(sf1);
    System.out.println(sf2);
    System.out.println(sf3);
    System.out.println(str2);
    System.out.println(str3);
    System.out.println(str5);
  }
}
