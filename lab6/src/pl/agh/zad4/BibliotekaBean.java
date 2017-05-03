package pl.agh.zad4;

import pl.agh.biblioteka.books.Book;
import pl.agh.biblioteka.books.Storage;

import javax.ejb.Stateful;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Jan on 02.05.2017.
 */

@Stateful(name = "BibliotekaEJB")
public class BibliotekaBean implements Biblioteka {
    Storage storage;
    private static final String LIBRARY_XML = "D:\\Java\\SOA-lab\\lab6\\xml\\lib.xml";
    private Marshaller m;
    private Unmarshaller u;

    public BibliotekaBean() {
        JAXBContext context = null;
        try {
            JAXBContext jaxbContext = null;
            jaxbContext = JAXBContext.newInstance(Storage.class);

            m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            u = jaxbContext.createUnmarshaller();
            storage = unmarshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean borrowBook(int id) {
        for (Book b:
                storage.getFreeBooks()) {
            if(id == b.getId()) {
                storage.getFreeBooks().remove(b);
                storage.getBorrowedBooks().add(b);
                marshal();
                return true;
            }
        }

        for (Book b:
                storage.getReservedBooks()) {
            if(id == b.getId()) {
                storage.getReservedBooks().remove(b);
                storage.getBorrowedBooks().add(b);
                marshal();

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean bookBook(int id) {
        for (Book b:
                storage.getFreeBooks()) {
            if(id == b.getId()) {
                storage.getFreeBooks().remove(b);
                storage.getReservedBooks().add(b);
                marshal();

                return true;
            }
        }

        for (Book b:
                storage.getBorrowedBooks()) {
            if(id == b.getId()) {
                storage.getBorrowedBooks().remove(b);
                storage.getReservedBooks().add(b);
                marshal();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean returnBook(int id) {
        for (Book b:
                storage.getBorrowedBooks()) {
            if(id == b.getId()) {
                storage.getBorrowedBooks().remove(b);
                storage.getFreeBooks().add(b);
                marshal();

                return true;
            }
        }

        for (Book b:
                storage.getReservedBooks()) {
            if(id == b.getId()) {
                storage.getReservedBooks().remove(b);
                storage.getFreeBooks().add(b);
                marshal();

                return true;
            }
        }

        return false;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }

    @Override
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    private Storage unmarshal() {
        Storage books1 = null;
        try {
            books1 = (Storage) u.unmarshal(new FileReader(LIBRARY_XML));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return books1;
    }

    private void marshal() {
        try {
            m.marshal(storage, new File(LIBRARY_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
