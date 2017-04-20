package pl.edu.agh.student.janpogocki.soa.lab5;

import org.w3c.dom.Element;
import pl.edu.agh.student.janpogocki.soa.lab5.zad3.Book;
import pl.edu.agh.student.janpogocki.soa.lab5.zad3.Books;
import pl.edu.agh.student.janpogocki.soa.lab5.zad3.Title;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jan on 20.04.2017.
 */
public class Zadanie3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("D:\\Java\\SOA-lab\\lab5\\xml\\zad1.xml");

        ArrayList<Book> bookList = new ArrayList<>();

        while (true) {

            Book book = new Book();
            List<Title> titleList = new ArrayList<>();

            System.out.println("Czy chcesz wprowadzić nową książkę? (tak/nie)");
            if (scanner.nextLine().equals("nie")) {
                save(bookList, file);
                break;
            }

            boolean hasAuthor = false;
            String authors = "";
            while (true) {
                System.out.print("Podaj autora książki: ");
                String autor = scanner.nextLine();

                if (autor.equals("") && hasAuthor)
                    break;
                else {
                    authors = authors + autor + "|";
                    hasAuthor = true;
                }
            }

            String [] authorsArray = authors.substring(0,authors.length()-2).split("\\|");
            book.setAuthor(Arrays.asList(authorsArray));

            while (true) {
                System.out.print("Podaj język tytułu: ");
                String lang = scanner.nextLine();
                if (!lang.equals("")) {
                    System.out.print("Podaj tytuł książki w języku \"" + lang + "\": ");
                    String title = scanner.nextLine();
                    Title titlee = new Title(lang, title);
                    titleList.add(titlee);
                } else {
                    book.setTitle(titleList);
                    break;
                }
            }

            System.out.print("Podaj numer ISBN książki: ");
            book.setIsbn(scanner.nextLine());

            System.out.println("Czy dane są poprawne? (tak/nie)");
            if (scanner.nextLine().equals("tak"))
                bookList.add(book);
        }
    }

    public static void save(ArrayList<Book> bookList, File file) {
        try {
            Books books = new Books();
            books.setBook(bookList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(books, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
