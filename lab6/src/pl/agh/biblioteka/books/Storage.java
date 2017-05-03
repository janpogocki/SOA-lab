package pl.agh.biblioteka.books;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 02.05.2017.
 */

@XmlRootElement(name = "Storage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Storage {
    public Storage() {
        freeBooks = new ArrayList<>();
        reservedBooks = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    @XmlElement(name = "freeBook")
    private List<Book> freeBooks;

    @XmlElement(name = "reservedBook")
    private List<Book> reservedBooks;

    @XmlElement(name = "borrowedBook")
    private List<Book> borrowedBooks;

    public List<Book> getFreeBooks() {
        return freeBooks;
    }

    public void setFreeBooks(List<Book> freeBooks) {
        this.freeBooks = freeBooks;
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void setReservedBooks(List<Book> reservedBooks) {
        this.reservedBooks = reservedBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
