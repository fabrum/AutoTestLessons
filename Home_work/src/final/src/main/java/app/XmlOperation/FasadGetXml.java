package app.XmlOperation;





import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class FasadGetXml {


    private static final String TEST_XML = "Steps_for_bad_login.xml";

    public static List<Test> getDataFromXml() throws ParserConfigurationException, SAXException, IOException, XMLStreamException{
    DocumentBuilderFactory dbFactoryTest = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilderTest = dbFactoryTest.newDocumentBuilder();
    Document documentTest = dBuilderTest.parse(TEST_XML);
    return  new DomParserTest().parseTest(documentTest);
}

}
