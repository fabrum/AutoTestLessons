package stax;
import model.Test;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxParserTest {

    private static final String STEP1 = "step1";
    private static final String STEP2 = "step2";
    private static final String STEP3 = "step3";
    private static final String TEST = "test";
    private static final String ID = "id";
    private Test test;
    List<Test> tests = new ArrayList<>();

    public List<Test> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException
    {
        while (xmlEventReader.hasNext())
        {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return tests;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException
    {
        if (xmlEvent.isStartElement())
        {


            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, TEST))
            {
                test = new Test();
                Attribute attribute = startElement.getAttributeByName(new QName(ID));
                if (attribute != null)
                {
                    test.setId(Integer.parseInt(attribute.getValue()));
                }

            }
            // set the other varibles from xml elements

            else if (isTagNameEqual(startElement, STEP1))
            {
                test.setStep1(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, STEP2))
            {
                test.setStep2(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, STEP3))
            {
                test.setStep3(xmlEventReader.nextEvent().asCharacters().getData());
            }

        }
    }

    private void proceedEndElement(XMLEvent xmlEvent)
    {
        if (xmlEvent.isEndElement())
        {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(TEST))
            {
                tests.add(test);
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName)
    {
        return startElement.getName().getLocalPart().equals(tagName);
    }

}
