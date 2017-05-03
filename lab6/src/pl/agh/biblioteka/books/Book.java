package pl.agh.biblioteka.books;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Jan on 20.04.2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
        "id",
        "author",
        "title",
        "isbn"
})
public class Book {
    @XmlElement(required = true)
    private int id;

    @XmlElement(required = true)
    private List<String> author;

    @XmlElement(required = true)
    private List<Title> title;

    @XmlElement(required = true)
    private String isbn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<Title> getTitle() {
        return title;
    }

    public void setTitle(List<Title> title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
