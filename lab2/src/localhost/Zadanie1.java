package localhost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jan on 16.03.2017.
 * Napisz aplikacje internetowa wykorzystując koncepcje servleta, pozwalającą sprawdzić czy podane
 na stronie internetowej dane ( imie oraz wiek) należą do pełnoletniej kobiety czy też nie. Imię
 kobiece rozpoznajemy po końcówce ‘a’.
 */
@WebServlet(name = "Zadanie1")
public class Zadanie1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        int wiek = Integer.parseInt(request.getParameter("wiek"));

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Witaj " + imie + "! ");

        if (imie.endsWith("a")) {
            out.println("Jesteś kobietą ");
            if (wiek >= 18)
                out.println("pełnoletnią, ");
            else
                out.println("niepełnoletnią, ");
        }
        else {
            out.println("Jesteś mężczyzną ");
            if (wiek >= 18)
                out.println("pełnoletnim, ");
            else
                out.println("niepełnoletnim, ");
        }

        out.println("bo masz " + wiek + " lat.");
        out.close();
    }
}
