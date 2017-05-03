package pl.agh.zad4;

import pl.agh.biblioteka.books.Storage;

/**
 * Created by Jan on 02.05.2017.
 */

public interface Biblioteka {
    public boolean borrowBook(int id);
    public boolean bookBook(int id);
    public boolean returnBook(int id);
    public Storage getStorage();
    public void setStorage(Storage bookStorage);
}
