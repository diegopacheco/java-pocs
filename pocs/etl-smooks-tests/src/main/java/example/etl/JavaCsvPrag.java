package example.etl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.csv.CSVBinding;
import org.milyn.csv.CSVBindingType;
import org.milyn.csv.CSVReaderConfigurator;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringSource;
import org.xml.sax.SAXException;

import example.pojos.Customer;

public class JavaCsvPrag {

	private static String messageIn = readInputMessage();

	@SuppressWarnings("unchecked")
	protected static List runSmooksTransform() throws IOException, SAXException, SmooksException {

		Smooks smooks = new Smooks();

		try {
			// ****
			// And here's the configuration... configuring the CSV reader and
			// the direct
			// binding config to create a List of Person objects
			// (List<Person>)...
			// ****
			smooks.setReaderConfig(new CSVReaderConfigurator("firstName,lastName,gender,age,country")
					.setBinding(new CSVBinding("customerList", Customer.class, CSVBindingType.LIST)));

			// Configure the execution context to generate a report...
			ExecutionContext executionContext = smooks.createExecutionContext();
			executionContext.setEventListener(new HtmlReportGenerator("target/report/report.html"));

			JavaResult javaResult = new JavaResult();
			smooks.filterSource(executionContext, new StringSource(messageIn),javaResult);

			return (List) javaResult.getBean("customerList");
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
			return StreamUtils.readStreamAsString(new FileInputStream(new File("").getAbsolutePath() +  "/src/main/resources/input-sources/input-message.csv"));
		} catch (IOException e) {
			e.printStackTrace();
			return "<no-message/>";
		}
	}
}
