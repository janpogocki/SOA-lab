package pl.agh.biblioteka.books;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan on 20.04.2017.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "books", propOrder = {
        "book"
})
public class Books {
    protected List<Book> book;

    public List<Book> getBook() {
        if (book == null) {
            book = new ArrayList<>();
        }
        return this.book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
