
public class Lambda {

	interface MathOperation {
		int operation(int a, int b);
	}

	static int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	static MathOperation addition    = (int a, int b) -> a + b;
	static MathOperation subtraction = (a, b) -> a - b;

	public static void main(String args[]) {
		System.out.println("10 + 5 = " + operate(10, 5, addition));
		System.out.println("10 - 5 = " + operate(10, 5, subtraction));
		System.out.println("10 - 5 = " + operate(10, 5, (int a, int b) -> a * b));
	}
}
/*
10 + 5 = 15
10 - 5 = 5
10 - 5 = 50
*/
