import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser;
import com.github.diegopacheco.javaplayground.dsl.MathVisitor;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main{

  private static void eval(String input){
    System.out.println("Eval init... ");
    MathOperationsLexer lexer = new MathOperationsLexer(CharStreams.fromString(input));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MathOperationsParser parser = new MathOperationsParser(tokens);
    ParseTree tree = parser.prog();
    MathVisitor visitor = new MathVisitor();
    visitor.visit(tree);
    System.out.println("Eval end. ");
  }

  public static void main(String[] args) {
    eval("1 plus 10\n" + // should be 11
              "200 divided by 200\n" + // should be 1
              "500 plus 10 minus 1\n" + // should be 509
              "20 multiply by 2 plus 25"); // should be 65
    eval("10 plus 10 add 6"); // should be 26
  }
}
