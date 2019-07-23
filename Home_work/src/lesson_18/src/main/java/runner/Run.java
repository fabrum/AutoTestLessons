package runner;

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

import model.Country;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import dom.DomParser;
import dom.DomParserTest;
import model.Employee;
import model.Test;
import sax.CountryHandler;
import sax.EmployeeHandler;
import sax.TestHandler;
import stax.StaxParser2;
import stax.StaxParserTest;


public class Run
{

    private static final String EMPLOYEES_XML = "employees.xml";
    private static final String REFS_XML = "Refs.xml";
    private static final String TEST_XML = "Steps_for_bad_login.xml";
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException
    {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        EmployeeHandler employeeHandler = new EmployeeHandler();
        saxParser.parse(new File(EMPLOYEES_XML), employeeHandler);
        List<Employee> employees = employeeHandler.getEmployees();
        employees.forEach(employee -> System.out.println(employee));
/*
        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(EMPLOYEES_XML));
        employees = new StaxParser().parse(xmlEventReader);
        employees.forEach(employee -> System.out.println(employee));
*/
    System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(EMPLOYEES_XML);
        employees = new DomParser().parse(document);
        employees.forEach(employee -> System.out.println(employee));


        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory2 = SAXParserFactory.newInstance();
        SAXParser saxParser2 = saxParserFactory2.newSAXParser();
        CountryHandler countryHandler = new CountryHandler();
        saxParser2.parse(new File(REFS_XML), countryHandler);
        List<Country> countries = countryHandler.getCountries();
        countries.forEach(employee -> System.out.println(employee));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(REFS_XML));
        countries = new StaxParser2().parse(xmlEventReader);
        countries.forEach(employee -> System.out.println(employee));

   /*     System.out.println(" ============================== DOM parser 2=========================");
        DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
        Document document2 = dBuilder2.parse(REFS_XML);
        countries = new DomParser2().parse2(document2);
        countries.forEach(employee -> System.out.println(employee));
*/

        System.out.println(" ============================== DOM parser t=========================");
        DocumentBuilderFactory dbFactoryTest = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilderTest = dbFactoryTest.newDocumentBuilder();
        Document documentTest = dBuilderTest.parse(TEST_XML);
        List<Test> tests;
        tests = new DomParserTest().parseTest(documentTest);

        tests.forEach(test -> System.out.println(test));
        System.out.println(tests.get(1).getStep1());

        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxTestFactory = SAXParserFactory.newInstance();
        SAXParser saxTestParser = saxTestFactory.newSAXParser();
        TestHandler testHandler = new TestHandler();
        saxTestParser.parse(new File(TEST_XML), testHandler);
         tests= testHandler.getTests();
        tests.forEach(test -> System.out.println(test));


        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory3 = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader3 = xmlInputFactory3.createXMLEventReader(new FileInputStream(TEST_XML));
        tests = new StaxParserTest().parse(xmlEventReader3);
        tests.forEach(employee -> System.out.println(employee));





    }

}
