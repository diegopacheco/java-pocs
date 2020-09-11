import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Base64;

/*
*  HEX to Bin, Dec and Base64 and back.
*
*  HEX      = 1234abcd12ab34cd56ef1234567890ab
*  BIN      = 10010001101001010101111001101000100101010101100110100110011010101011011101111000100100011010001010110011110001001000010101011 HEX BACK: 1234abcd12ab34cd56ef1234567890ab
*  DEC      = 24199587900365542451626017331269374123 HEX BACK: 1234ABCD12AB34CD56EF1234567890AB
*  BASE64   = MTAwMTAwMDExMDEwMDEwMTAxMDExMTEwMDExMDEwMDAxMDAxMDEwMTAxMDExMDAxMTAxMDAxMTAwMTEwMTAxMDEwMTEwMTExMDExMTEwMDAxMDAxMDAwMTEwMTAwMDEwMTAxMTAwMTExMTAwMDEwMDEwMDAwMTAxMDEwMTE=HEX BACK: 1234abcd12ab34cd56ef1234567890ab
*
* */
public class Main {

    public static void main(String args[]) {
        System.out.println("HEX      = 1234abcd12ab34cd56ef1234567890ab");
        System.out.println("BIN      = " + hexToBinary("1234abcd12ab34cd56ef1234567890ab") + " HEX BACK: " + binToHex(hexToBinary("1234abcd12ab34cd56ef1234567890ab")) );
        System.out.println("DEC      = " + binToDec(hexToBinary("1234abcd12ab34cd56ef1234567890ab")) + " HEX BACK: " + decToHex(binToDec(hexToBinary("1234abcd12ab34cd56ef1234567890ab"))) );
        System.out.println("BASE64   = " + binToBase64(hexToBinary("1234abcd12ab34cd56ef1234567890ab")) + "HEX BACK: " + binToHex(base64ToBin(binToBase64(hexToBinary("1234abcd12ab34cd56ef1234567890ab")))) );
    }

    private static String binToHex(String binaryString) {
        return new BigInteger(binaryString, 2).toString(16);
    }

    private static String hexToBinary(String hex) {
        return new BigInteger(hex, 16).toString(2);
    }

    private static String binToDec(String binaryString) {
        BigDecimal bd1 = new BigDecimal(binaryString.charAt(0)=='1'?1:0);
        BigDecimal two = new BigDecimal(2);
        for (int i = 1; i<binaryString.length(); i++) {
            bd1 = bd1.multiply(two);
            bd1 = bd1.add(new BigDecimal(binaryString.charAt(i)=='1'?1:0));
        }
        return bd1.toString();
    }

    private static String binToBase64(String binaryString) {
        try {
            return new String(Base64.getEncoder().encode(binaryString.getBytes("UTF-8")), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String base64ToBin(String binaryString) {
        try {
            return new String(Base64.getDecoder().decode(binaryString.getBytes("UTF-8")), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String decToHex(String dec) {
        BigDecimal bd = new BigDecimal(dec);
        return String.format("%X", bd.toBigInteger());
    }

}
