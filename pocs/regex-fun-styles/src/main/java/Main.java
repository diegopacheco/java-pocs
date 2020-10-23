import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
  public static void main(String args[]){
    nood();
    pro();
    me();
  }

  private static void nood(){
    final Pattern PATTERN = Pattern.compile("^s(.*)g$");
    Matcher matcher = PATTERN.matcher("something");
    if (matcher.find()){
      System.out.println(matcher.group(1));
    }
  }
  private static void pro(){
    final Pattern PATTERN = Pattern.compile("^s(.*)g$");
    Matcher m; if (( m = PATTERN.matcher("something")).find())
      System.out.println(m.group(1));
  }
  private static void me(){
    final Pattern PATTERN = Pattern.compile("^s(.*)g$");
    for (Matcher m =PATTERN.matcher("something"); m.find();
      System.out.println(m.group(1)));
  }

}
