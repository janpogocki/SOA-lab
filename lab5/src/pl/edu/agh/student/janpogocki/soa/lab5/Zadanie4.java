package pl.edu.agh.student.janpogocki.soa.lab5;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jan on 19.04.2017.
 */
public class Zadanie4 {
    public static void main(String[] args) {
        File schemaFile = new File("D:\\Java\\SOA-lab\\lab5\\xml\\pracownicy.xsd");
        Source xmlFile = new StreamSource(new File("D:\\Java\\SOA-lab\\lab5\\xml\\zad4.xml"));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println("Plik XML jest poprawny.");
        } catch (SAXException | IOException e) {
            System.out.println("Plik XML **nie jest** poprawny.\n\n" + e);
        }
    }
}
