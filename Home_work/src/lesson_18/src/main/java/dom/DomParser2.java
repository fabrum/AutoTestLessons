package dom;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import model.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Country;
public class DomParser2 {

    public List<Country> parse2(Document document2) throws FileNotFoundException, XMLStreamException
    {
        NodeList nodeList = document2.getElementsByTagName("Country");
        List<Country> countries = new ArrayList<Country> ();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            countries.add(getCountry(nodeList.item(i)));
        }
        return countries;
    }








    private static Country getCountry(Node node)
    {
        Country country = new Country();
        Element element = (Element) node;
        country.setId(Integer.parseInt(element.getAttribute("id")));
        country.setName(getTagValue("Name", element));
        country.setDescription(getTagValue("Description", element));
        country.setCode(getTagValue("Code", element));

        return country;
    }

    private static String getTagValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
