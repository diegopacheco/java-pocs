
public class Main{

  public static void main(String args[]){
    bitwiseOR();
    bitwiseAND();
    bitwiseXOR();
    bitwiseComplement();
    bitwiseSignedRightShift();
    bitwiseUnsignedRightShift();
    //bitwiseLeftShift(); // not in java
  }

  /**
   * Bitwise OR (|) –
   * This operator is a binary operator, denoted by ‘|’. It returns bit by bit OR of input values, i.e, if either of the bits is 1, it gives 1, else it gives 0.
   * For example,
   * a = 5 = 0101 (In Binary)
   * b = 7 = 0111 (In Binary)
   * Bitwise OR Operation of 5 and 7
   *   0101
   * | 0111
   *  ________
   *   0111  = 7 (In decimal)
   */
  private static void bitwiseOR(){
    int a = 5;
    int b = 7;
    int result = a | b;
    System.out.println("a|b=="+result);
  }

  /*
  * Bitwise AND (&) –
  * This operator is a binary operator, denoted by ‘&’.
  * It returns bit by bit AND of input values, i.e,
  * if both bits are 1, it gives 1, else it gives 0.
  * For example,
  * a = 5 = 0101 (In Binary)
  * b = 7 = 0111 (In Binary)
  * Bitwise AND Operation of 5 and 7
  *   0101
  * & 0111
  * ________
  *   0101  = 5 (In decimal)
  * */
  private static void bitwiseAND(){
    int a = 5;
    int b = 7;
    int result = a & b;
    System.out.println("a&b=="+result);
  }

  /**
   * Bitwise XOR (^) –
   * This operator is a binary operator, denoted by ‘^’.
   * It returns bit by bit XOR of input values, i.e, if corresponding bits are different,
   * it gives 1, else it gives 0.
   * For example,
   * a = 5 = 0101 (In Binary)
   * b = 7 = 0111 (In Binary)
   * Bitwise XOR Operation of 5 and 7
   *   0101
   * ^ 0111
   *  ________
   *   0010  = 2 (In decimal)
   */
  private static void bitwiseXOR(){
    int a = 5;
    int b = 7;
    int result = a^b;
    System.out.println("a^b=="+result);
  }

  /**
   * Bitwise Complement (~) –
   * This operator is a unary operator, denoted by ‘~’.
   * It returns the one’s complement representation of the input value, i.e,
   * with all bits inverted, which means it makes every 0 to 1, and every 1 to 0.
   * For example,
   * a = 5 = 0101 (In Binary)
   * Bitwise Compliment Operation of 5
   * ~ 0101
   *  ________
   *   1010  = 10 (In decimal)
   * Note – Compiler will give 2’s complement of that number, i.e.,
   * 2’s complement of 10 will be -6.
   */
  private static void bitwiseComplement(){
    int a = 5;
    int result = ~5;
    System.out.println("~a=="+result);
  }

  /**
   * Signed Right shift operator (>>) –
   * Shifts the bits of the number to the right and fills the voids left
   * with the sign bit (1 in case of negative number and 0 in case of positive number).
   * The leftmost bit and a depends on the sign of initial number.
   * Similar effect as of dividing the number with some power of two.
   * Example:
   * a = -10
   * a>>1 = -5
   * We preserve the sign bit.
   */
  private static void bitwiseSignedRightShift(){
    int a = -10;
    int b = 1;
    int result = a>>b;
    System.out.println("a>>b=="+result);
  }

  /**
   * Unsigned Right shift operator (>>>) –
   * Shifts the bits of the number to the right and fills 0 on voids left as a result.
   * The leftmost bit is set to 0. (>>>) is unsigned-shift; it’ll insert 0.
   * (>>) is signed, and will extend the sign bit.
   * Example:
   * a = -10
   * a>>>1 = 2147483643
   * DOES NOT preserve the sign bit.
   */
  private static void bitwiseUnsignedRightShift(){
    int a = -10;
    int b = 1;
    int result = a>>>b;
    System.out.println("a>>>b=="+result);
  }

  /**
   * Left shift operator (<<) –
   * Shifts the bits of the number to the left and fills 0 on voids left as a result.
   * Similar effect as of multiplying the number with some power of two.
   * For example,
   * a = 5 = 0000 0101
   * b = -10 = 1111 0110
   * a << 1 = 0000 1010 = 10
   * a << 2 = 0001 0100 = 20
   */
  private static void bitwiseLeftShift(){
    int a = 5;
    int b = 1;
    int result = a<<1;
    System.out.println("a<<b=="+result);
  }

  /**
   * Unsigned Left shift operator (<<<) –
   * Unlike unsigned Right Shift, there is no “<<<” operator in Java,
   * because the logical (<<) and arithmetic left-shift (<<<) operations are identical.
   */
  private static void bitwiseUnsignedLeftShift(){
    throw new UnsupportedOperationException("Not possible!");
  }

}
