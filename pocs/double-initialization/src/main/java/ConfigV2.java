import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ConfigV2{

    private List<String> dependencies = new ArrayList<>();

    // Has a couple of benefits over previous design
    // XML processing is cached.
    // We use the FileInputStream and close it so there is not leak
    // All is done in the constructor.
    public ConfigV2(){
        try {
            FileInputStream fis = new FileInputStream(
                    new File(
                            Config.class.getResource("config.xml").toURI()
                    ));

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

            fis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getDownstreamDependencies() {
        try {
            return dependencies;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
