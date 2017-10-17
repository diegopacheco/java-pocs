import java.util.function.UnaryOperator;

public class Recursion {

	public static final UnaryOperator<Integer> count = 
			x -> x == 0 
			? 
			0 : x + Recursion.count.apply(x - 1);

	public static void main(String[] args) {
		for (int i = 0;; i++) {
			System.out.println(i + ": " + count.apply(i));
		}
	}
}