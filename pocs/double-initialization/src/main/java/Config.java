import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Config implements Closeable {

    private FileInputStream fis;

    public Config() {
        // why no initialize FIS here?
        // because if fails, the close method would not be called:
        //   try (Config config = new Config()) {
        //      // some code...
        //   }
        //
        //  This means that try with resource expect that line to succeed or in other words constructor need to be ok.
        //  IF the constructor fails later, there is a leak, the best think to do is make sure there is no leak with proper try/catch
        //  this make sense to me as the constructor needs to abstract the object creation, double initialization is weired
        //  IS a form of lazy loading, what if no one call it? this could be a problem if there is a library.
        //  Closeable give you a callback, does not help you 100% with resource utilization. If you will use resources, will need to
        //  manage them and make sure is all proper.
        //
    }

    public void init() {
        try {
            this.fis = new FileInputStream(
                    new File(
                            Config.class.getResource("config.xml").toURI()
                    ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getDownstreamDependencies() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/configuration/dependencies/downstream");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            List<String> deps = new ArrayList<>();
            for(int i=0;i<nodeList.getLength();i++){
                NodeList applications = nodeList.item(i).getChildNodes();
                deps.add(applications.item(1).getAttributes().getNamedItem("name").getNodeValue());
            }

            return deps;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {
        try {
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
