package pl.agh.zad3;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

/**
 * Created by Jan on 02.05.2017.
 */
@WebServlet(name = "Servlet3")
public class Servlet3 extends HttpServlet {
    private final static Hashtable jndiProperties = new Hashtable();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        Double temperatura = Double.parseDouble(request.getParameter("temperatura"));
        String jednostka = request.getParameter("jednostka");

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            if (jednostka.equals("c"))
                out.println(konwerterEJB().Cels2Fahr(temperatura) + " st. F");
            else
                out.println(konwerterEJB().Fahr2Cels(temperatura) + " st. C");
        } catch (NamingException e){
            e.printStackTrace();
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private static Konwerter konwerterEJB() throws NamingException {
        final Context context = new InitialContext(jndiProperties);
        return (Konwerter) context.lookup("java:comp/env/ejb/konwerter");
    }
}
