import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsParser;
import com.github.diegopacheco.javaplayground.dsl.MathVisitor;
import com.github.diegopacheco.javaplayground.dsl.generated.MathOperationsLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main{
  public static void main(String[] args){
    String input = "1 plus 10\n200 divided by 200\n500 plus 10 minus 1\n20 multiply by 2 add 25";
    MathOperationsLexer lexer = new MathOperationsLexer(CharStreams.fromString(input));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MathOperationsParser parser = new MathOperationsParser(tokens);
    ParseTree tree = parser.prog();
    MathVisitor visitor = new MathVisitor();
    visitor.visit(tree);
  }
}
