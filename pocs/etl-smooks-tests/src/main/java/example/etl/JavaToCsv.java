package example.etl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringSource;
import org.xml.sax.SAXException;

public class JavaToCsv {

	private static String messageIn = readInputMessage();

	@SuppressWarnings("unchecked")
	protected static List runSmooksTransform() throws IOException,SAXException, SmooksException {

		Smooks smooks = new Smooks("config-smooks/smooks-config.xml");

		try {
			ExecutionContext executionContext = smooks.createExecutionContext();
			JavaResult result = new JavaResult();

			// Configure the execution context to generate a report...
			executionContext.setEventListener(new HtmlReportGenerator("target/report/report.html"));

			smooks.filterSource(executionContext, new StringSource(messageIn),result);

			return (List) result.getBean("customerList");
		} finally {
			smooks.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, SAXException,SmooksException {
		System.out.println("\n\n==============Message In==============");
		System.out.println(new String(messageIn));
		System.out.println("======================================\n");
		
		long init = System.currentTimeMillis();
		
		List messageOut = JavaToCsv.runSmooksTransform();
		
		System.out.println("Tempo de processamento: " + (System.currentTimeMillis() - init) + "ms\n");

		System.out.println("==============Message Out=============");
		System.out.println(messageOut);
		System.out.println("======================================\n\n");
	}

	private static String readInputMessage() {
		try {
			return StreamUtils.readStreamAsString(new FileInputStream(new File("").getAbsolutePath() +  "/src/main/resources/input-sources/input-message.csv"));
		} catch (IOException e) {
			e.printStackTrace();
			return "<no-message/>";
		}
	}
}