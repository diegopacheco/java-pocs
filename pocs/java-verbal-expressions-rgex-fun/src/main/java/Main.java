import ru.lanwen.verbalregex.VerbalExpression;

public class Main{
  public static void main(String args[]){

    VerbalExpression testRegex = VerbalExpression.regex()
            .startOfLine().then("http").maybe("s")
            .then("://")
            .maybe("www.").anythingBut(" ")
            .endOfLine()
            .build();

    // Create an example URL
    String url = "https://www.google.com";

    // Use VerbalExpression's testExact() method to test if the entire string matches the regex
    System.out.println(testRegex.testExact(url)); //True

    System.out.println(testRegex.toString()); // Outputs the regex used:
    // ^(?:http)(?:s)?(?:\:\/\/)(?:www\.)?(?:[^\ ]*)$

  }
}
