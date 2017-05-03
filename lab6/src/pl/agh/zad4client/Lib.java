package pl.agh.zad4client;

import pl.agh.zad4.Biblioteka;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by Jan on 02.05.2017.
 */

@ManagedBean(name = "Lib", eager = true)
@SessionScoped
public class Lib {
    public Biblioteka library;

    public Lib() {

        String jndiName = "java:comp/env/ejb/bibl";
        Context context = null;
        try {
            context = new InitialContext();
            Object object = context.lookup(jndiName);
            this.library = (Biblioteka) object;

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Biblioteka getLibrary() {
        return library;
    }

    public void setLibrary(Biblioteka library) {
        this.library = library;
    }
}
