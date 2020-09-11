import java.math.BigInteger;
import java.util.Base64;

public class Main{
  public static void main(String args[]){
    System.out.println("HEX      =  1234abcd12ab34cd56ef1234567890ab");
    System.out.println("BIN      = " + hexToBinary("1234abcd12ab34cd56ef1234567890ab"));
    System.out.println("DEC      = " + binToDec(hexToBinary("1234abcd12ab34cd56ef1234567890ab")));
    System.out.println("BASE64   = " + binToBase64(hexToBinary("1234abcd12ab34cd56ef1234567890ab")));
    System.out.println("HEX BACK = " + binToHex( base64ToBin( binToBase64(hexToBinary("1234abcd12ab34cd56ef1234567890ab")))));
  }

  private static String hexToBinary(String hex) {
    return new BigInteger(hex, 16).toString(2);
  }

  private static int binToDec(String binaryString){
    double j=0;
    for(int i=0;i<binaryString.length();i++){
      if(binaryString.charAt(i)== '1'){
        j=j+ Math.pow(2,binaryString.length()-1-i);
      }
    }
    return (int) j;
  }

  private static String binToBase64(String binaryString){
    try{
      return new String(Base64.getEncoder().encode(binaryString.getBytes("UTF-8")),"UTF-8");
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static String base64ToBin(String binaryString){
    try{
      return new String(Base64.getDecoder().decode(binaryString.getBytes("UTF-8")),"UTF-8");
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static String binToHex(String binaryStr){
    return Integer.toString(Integer.parseInt(binaryStr,2),16);
  }

}
