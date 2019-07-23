package sax;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Test;

public class TestHandler extends DefaultHandler {

    private List<Test> tests;
    private Test test;
    boolean bStep1 = false;
    boolean bStep2 = false;
    boolean bStep3 = false;


    public List<Test> getTests()
    {
        return tests;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        if (qName.equalsIgnoreCase("test"))
        {
            String id = attributes.getValue("id");
            test = new Test();
            test.setId(Integer.parseInt(id));
            if (tests == null)
            {
                tests = new ArrayList<>();
            }
        }
        else if (qName.equalsIgnoreCase("step1"))
        {
            bStep1 = true;
        }
        else if (qName.equalsIgnoreCase("step2"))
        {
            bStep2 = true;
        }
        else if (qName.equalsIgnoreCase("step3"))
        {
            bStep3 = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equalsIgnoreCase("test"))
        {
            tests.add(test);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException
    {

        if (bStep1)
            {
            test.setStep1(new String(ch, start, length));
                bStep1 = false;
        }
        else if (bStep2)
        {
            test.setStep2(new String(ch, start, length));
            bStep2 = false;
        }
        else if (bStep3)
        {
            test.setStep3(new String(ch, start, length));
            bStep3 = false;
        }

    }
}
