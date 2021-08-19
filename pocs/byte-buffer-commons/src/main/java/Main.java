import com.github.diegopacheco.bytebuffer.ByteBufferUtils;

import java.nio.ByteBuffer;

public class Main{
  public static void main(String args[]){
    String str = "This is a test";
    ByteBuffer bb = ByteBufferUtils.stringToBB(str);

    String strFromBB = ByteBufferUtils.bbToString(bb);
    System.out.println("String are the same?" + str.equals(strFromBB));
    System.out.println("BB cloned? " + ByteBufferUtils.bbToString(ByteBufferUtils.clone(bb)));
  }
}
