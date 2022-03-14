import java.beans.XMLDecoder;
import java.io.InputStream;

public class XMLDecoderUtil {

    public static Object handleXML(InputStream is){
        XMLDecoder dec = new XMLDecoder(is);
        try{
            Object result = dec.readObject();
            return result;
        }finally {
            dec.close();
        }
    }

}