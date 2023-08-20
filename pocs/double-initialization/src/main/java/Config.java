import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
            // nodeList.item(0).getChildNodes().item(1).getAttributes().getNamedItem("name")
            List<String> deps = new ArrayList<>();
            for(int i=0;i<nodeList.getLength();i++){
                deps.add(nodeList.item(i).getNodeValue());
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
