package example.etl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.io.StreamUtils;
import org.milyn.payload.StringResult;
import org.xml.sax.SAXException;

public class GroovyXml {
	
	private static String messageIn = readInputMessage();
	
	protected static String runSmooksTransform(Reader messageIn) throws IOException, SAXException, SmooksException {
	    Smooks smooks = new Smooks("config-smooks/smooks-groovy-config.xml");
	 
	    try {
	        StringResult result = new StringResult();
	 
	        smooks.filterSource(new StreamSource(messageIn), result);
	 
	        return result.toString();
	    } finally {
	        smooks.close();
	    }
	}
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, SAXException, SmooksException {
		System.out.println("\n\n==============Message In==============");
		System.out.println(new String(messageIn));
		System.out.println("======================================\n");

		long init = System.currentTimeMillis();

		List messageOut = JavaCsvPrag.runSmooksTransform();

		System.out.println("Tempo de processamento: "
				+ (System.currentTimeMillis() - init) + "ms\n");

		System.out.println("==============Message Out=============");
		System.out.println(messageOut);
		System.out.println("======================================\n\n");
	}

	private static String readInputMessage() {
		try {
			return StreamUtils.readStreamAsString(new FileInputStream(new File("").getAbsolutePath() +  "/src/main/resources/input-sources/input-msg-groovy.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			return "<no-message/>";
		}
	}
	
}
