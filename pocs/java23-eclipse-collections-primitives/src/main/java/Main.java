import org.eclipse.collections.api.list.primitive.*;
import org.eclipse.collections.impl.list.primitive.*;
import org.eclipse.collections.impl.factory.primitive.*;

public class Main{
  public static void main(String args[]){
    //Mutable and immutable Lists, Sets, Bags, Stacks and Maps are available for all 8 primitive types
    MutableIntList intList =
            IntLists.mutable.of(1, 2, 3);
    MutableLongList longList =
            LongLists.mutable.of(1L, 2L, 3L);
    MutableCharList charList =
            CharLists.mutable.of('a', 'b', 'c');
    MutableShortList shortList =
            ShortLists.mutable.of((short)1, (short)2, (short)3);
    MutableByteList byteList =
            ByteLists.mutable.of((byte)1, (byte)2, (byte)3);
    MutableBooleanList booleanList =
            BooleanLists.mutable.of(true, false);
    MutableFloatList floatList =
            FloatLists.mutable.of(1.0f, 2.0f, 3.0f);
    MutableDoubleList doubleList =
            DoubleLists.mutable.of(1.0, 2.0, 3.0);

    //You can create a ranged ints with IntInterval
    IntInterval oneTo10 =
            IntInterval.fromTo(1, 10); // ints from 1 to 10
    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    IntInterval oneTo10By3 =
            IntInterval.fromToBy(1, 10, 3); // ints from 1 to 10 step by 3
    // [1, 4, 7, 10]
    IntInterval oddsFrom1To10 =
            IntInterval.oddsFromTo(1, 10); // odd ints from 1 to 10
    // [1, 3, 5, 7, 9]
    IntInterval evensFrom1To10 =
            IntInterval.evensFromTo(1, 10); // even ints from 1 to 10
    // [2, 4, 6, 8, 10]

    System.out.println("Int List: " + intList);
    System.out.println("Long List: " + longList);
    System.out.println("Char List: " + charList);
    System.out.println("Short List: " + shortList);
    System.out.println("Byte List: " + byteList);
    System.out.println("Boolean List: " + booleanList);
    System.out.println("Float List: " + floatList);
    System.out.println("Double List: " + doubleList);
    System.out.println("One to 10 Interval: " + oneTo10);
    System.out.println("One to 10 by 3 Interval: " + oneTo10By3);
    System.out.println("Odds from 1 to 10 Interval: " + oddsFrom1To10);
    System.out.println("Evens from 1 to 10 Interval: " + evensFrom1To10);
  }
}