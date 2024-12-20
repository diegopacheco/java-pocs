import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser;
import com.github.diegopacheco.javaplayground.dsl.MathVisitor;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main{

  private static void eval(String input){
    System.out.print(STR."Input: \{input} Result == ");
    MathOperationsLexer lexer = new MathOperationsLexer(CharStreams.fromString(input+"\n"));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MathOperationsParser parser = new MathOperationsParser(tokens);
    ParseTree tree = parser.prog();
    MathVisitor visitor = new MathVisitor();
    visitor.visit(tree);
  }

  public static void main(String[] args) {
    eval("10 plus 10");
    eval("200 divided by 200");
    eval("500 plus 10 minus 1");
    eval("20 multiply by 2 plus 25");
    eval("10 plus 10 add 6");
    eval("10 plus 2 add 6 plus 2");
  }
}
