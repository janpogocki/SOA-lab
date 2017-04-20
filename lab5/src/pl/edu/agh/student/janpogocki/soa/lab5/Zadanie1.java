package pl.edu.agh.student.janpogocki.soa.lab5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(true);
        dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

        DocumentBuilder db = null;

        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = db.newDocument();
        Scanner scanner = new Scanner(System.in);
        Element elementBooks = doc.createElement("books");

        // BEGIN ============================

        while (true){
            System.out.println("Czy chcesz wprowadzić nową książkę? (tak/nie)");
            if (scanner.nextLine().toLowerCase().equals("nie"))
                break;

            Element elementBook = doc.createElement("book");

            boolean hasAuthor = false;
            while (true) {
                System.out.print("Podaj autora książki: ");
                String autor = scanner.nextLine();

                if (autor.equals("") && hasAuthor)
                    break;
                else {
                    Element elementAuthor = doc.createElement("author");
                    elementAuthor.setTextContent(autor);
                    elementBook.appendChild(elementAuthor);
                    hasAuthor = true;
                }
            }

            boolean hasTitleAndLang = false;
            while (true){
                System.out.print("Podaj język tytułu: ");
                String jezyk = scanner.nextLine();

                System.out.print("Podaj tytuł książki w języku \"" + jezyk + "\": ");
                String tytul = scanner.nextLine();

                if (jezyk.equals("") && tytul.equals("") && hasTitleAndLang)
                    break;
                else {
                    Element elementTitle = doc.createElement("title");
                    elementTitle.setAttribute("lang", jezyk);
                    elementTitle.setTextContent(tytul);
                    elementBook.appendChild(elementTitle);
                    hasTitleAndLang = true;
                }
            }

            System.out.print("Podaj numer ISBN książki: ");
            String isbn = scanner.nextLine();
            Element elementISBN = doc.createElement("isbn");
            elementISBN.setTextContent(isbn);
            elementBook.appendChild(elementISBN);

            System.out.println("Czy dane są poprawne? (tak/nie)");
            String poprawneDane = scanner.nextLine();
            if (poprawneDane.equals("tak"))
                elementBooks.appendChild(elementBook);
        }

        doc.appendChild(elementBooks);

        // END ==============================

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = null;

        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT,"yes");
        Source source = new DOMSource(doc);
        Result result = new StreamResult(new File("D:\\Java\\SOA-lab\\lab5\\xml\\zad1.xml"));

        System.out.println("Plik został zapisany!");

        try {
            t.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
