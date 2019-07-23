package app.XmlOperation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DomParserTest {
    public List<Test> parseTest(Document documentTest) throws FileNotFoundException, XMLStreamException
    {
        NodeList nodeList = documentTest.getElementsByTagName("test");
        List<Test> tests = new ArrayList<Test> ();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            tests.add(getTest(nodeList.item(i)));
        }
        return tests;
    }

    private static Test getTest(Node node)
    {
        Test test = new Test();
        Element element = (Element) node;
        test.setId(Integer.parseInt(element.getAttribute("id")));
        test.setStep1(getTagValue("step1", element));
        test.setStep2(getTagValue("step2", element));
        test.setStep3(getTagValue("step3", element));

        return test;
    }

    private static String getTagValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
