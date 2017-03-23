package localhost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Jan on 22.03.2017.
 */
@WebServlet(name = "CarChoiceServlet")
public class CarChoiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String rodzaj = request.getParameter("rodzaj");
        String przedzial = request.getParameter("przedzial");

        out.println("Rodzaj samochodu:" + rodzaj  + "<br>Przedział cenowy (od-do): " + przedzial + "<br><br>Propozycje:<br><br>");

        CarChoiceHelper carChoiceHelper = new CarChoiceHelper(rodzaj, przedzial);
        out.println(printHTMLlist(carChoiceHelper.getListOfCars()));

        out.close();
    }

    private String printHTMLlist(List<String> list){
        String returned = "";

        for (String element : list)
            returned = returned + element + "<br>";

        return returned;
    }
}
