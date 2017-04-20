package pl.edu.agh.student.janpogocki.soa.lab5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.lang.model.util.Elements;
import javax.print.Doc;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jan on 19.04.2017.
 * Zad 2
 */

public class Zadanie2 {
    public static void main(String[] args) {
        File schemaFile = new File("D:\\Java\\SOA-lab\\lab5\\xml\\books.xsd");
        Source xmlFile = new StreamSource(new File("D:\\Java\\SOA-lab\\lab5\\xml\\zad1.xml"));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println("Plik XML jest poprawny.");
            printBooks();
        } catch (SAXException | IOException e) {
            System.out.println("Plik XML **nie jest** poprawny.");
        }
    }

    private static void printBooks(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new File("D:\\Java\\SOA-lab\\lab5\\xml\\zad1.xml"));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        Element root = doc.getDocumentElement();
        NodeList books = root.getElementsByTagName("book");

        System.out.print("\n");

        for (int i = 0; i< books.getLength(); i++){
            NodeList book = books.item(i).getChildNodes();

            System.out.print("Autorzy: ");
            for (int j=0; j<book.getLength(); j++){
                Node item = book.item(j);

                if (item.getNodeName().equals("author"))
                    System.out.print(item.getTextContent() + ", ");

                if (item.getNodeName().equals("title"))
                    System.out.print("\nTytuł w języku \"" + item.getAttributes().getNamedItem("lang").getTextContent() + "\": " + item.getTextContent());

                if (item.getNodeName().equals("isbn"))
                    System.out.print("\nISBN: " + item.getTextContent());
            }

            System.out.print("\n\n");
        }
    }
}
