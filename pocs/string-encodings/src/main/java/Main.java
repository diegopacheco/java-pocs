import java.nio.charset.StandardCharsets;

public class Main{
  public static void main(String args[]){
    showConversionTable("Vergnügen".getBytes(StandardCharsets.UTF_8));
    showConversionTable("Vergnügen".getBytes(StandardCharsets.ISO_8859_1));
    showConversionTable("Vergnügen".getBytes(StandardCharsets.US_ASCII));

    showConversionTable("test".getBytes(StandardCharsets.UTF_8));
    showConversionTable("test".getBytes(StandardCharsets.ISO_8859_1));
    showConversionTable("test".getBytes(StandardCharsets.US_ASCII));
  }

  public static String convert(String source,String fromEncoding,String toEncoding){
    try{
      String newStr = new String(source.getBytes(fromEncoding),toEncoding);
      return newStr;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public static void showConversionTable(byte[] bytes){
    System.out.println("******");
    String strLatin1   = new String(bytes, StandardCharsets.ISO_8859_1);
    String strUTF8     = new String(bytes, StandardCharsets.UTF_8);
    String strUS_ASCII = new String(bytes, StandardCharsets.US_ASCII);

    System.out.println("Latin1 to Latin1 " + convert(strLatin1,
            StandardCharsets.ISO_8859_1.name(),
            StandardCharsets.ISO_8859_1.name()
    ));

    System.out.println("Latin1 to UTF8 " + convert(strLatin1,
            StandardCharsets.ISO_8859_1.name(),
            StandardCharsets.UTF_8.name()
    ));

    System.out.println("Latin1 to US_ASCII " + convert(strLatin1,
            StandardCharsets.ISO_8859_1.name(),
            StandardCharsets.US_ASCII.name()
    ));

    System.out.println("UTF8 to UTF8 " + convert(strUTF8,
            StandardCharsets.UTF_8.name(),
            StandardCharsets.UTF_8.name()
    ));

    System.out.println("UTF8 to Latin1 " + convert(strUTF8,
            StandardCharsets.UTF_8.name(),
            StandardCharsets.ISO_8859_1.name()
    ));

    System.out.println("UTF8 to US_ASCII " + convert(strUTF8,
            StandardCharsets.UTF_8.name(),
            StandardCharsets.US_ASCII.name()
    ));

    System.out.println("US_ASCII to US_ASCII " + convert(strUS_ASCII,
            StandardCharsets.US_ASCII.name(),
            StandardCharsets.US_ASCII.name()
    ));

    System.out.println("US_ASCII to Latin1 " + convert(strUS_ASCII,
            StandardCharsets.US_ASCII.name(),
            StandardCharsets.ISO_8859_1.name()
    ));

    System.out.println("US_ASCII to UTF-8 " + convert(strUS_ASCII,
            StandardCharsets.US_ASCII.name(),
            StandardCharsets.UTF_8.name()
    ));
  }

}
