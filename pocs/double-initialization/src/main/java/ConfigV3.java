import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigV3 implements Closeable {

    private FileInputStream fis;
    private List<String> dependencies = new ArrayList<>();

    //
    // V3: Implementation
    //
    // V2 was great, but you could not easily test it.
    // V3 receives the FileInputStream, so now we can point to a different file to test it.
    // We also have the cache as V2 has on the contructor, we can use Try safely now.
    //
    public ConfigV3(FileInputStream fis){
        this.fis = fis;

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/configuration/dependencies/downstream");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for(int i=0;i<nodeList.getLength();i++){
                NodeList applications = nodeList.item(i).getChildNodes();
                dependencies.add(applications.item(1).getAttributes().getNamedItem("name").getNodeValue());
            }

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<String> getDownstreamDependencies() {
        return dependencies;
    }

    @Override
    public void close() throws IOException {
        fis.close();
    }
}
