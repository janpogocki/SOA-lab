package com.example.web.WyborPiwa;

import com.example.model.EkspertPiwny;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jan on 23.03.2017.
 */
@WebServlet(name = "Servlet_wybierzpiwo")
public class Servlet_wybierzpiwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("kolor");
        String wiek = request.getParameter("wiek");

        // porada piwna
        EkspertPiwny ekspertPiwny = new EkspertPiwny();
        List<String> marki = ekspertPiwny.getMarki(c);

        request.setAttribute("marki", marki);
        RequestDispatcher view = request.getRequestDispatcher("wynik.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
