package com.example.Zadanie5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet_Zadanie5")
public class Servlet_Zadanie5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("filmy", getFilmy());
        RequestDispatcher view = req.getRequestDispatcher("Zadanie5.jsp");
        view.forward(req, resp);
    }
    
    public ArrayList<Film> getFilmy() {
        ArrayList<Film> filmy = new ArrayList<>();
        filmy.add(new Film("Ojciec chrzestny", "dramat", "1972", 120000000));
        filmy.add(new Film("Pluton", "wojenny", "1986", 50000000));
        filmy.add(new Film("Nagi instynkt", "thriller", "1992", 100000000));
        filmy.add(new Film("Scarface", "dramat", "1983", 65000000));
        filmy.add(new Film("Jak rozpętałem drugą wojnę światową", "wojenny", "1969", 50000000));
        return filmy;
    }

}
            
            