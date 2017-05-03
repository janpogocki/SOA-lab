package com.zad2;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 04.05.2017.
 */
@WebServlet(urlPatterns = "zad2")
public class Servlet2 extends HttpServlet {
    @EJB
    Producer2 producer2;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nazwa = request.getParameter("nazwa");
        String rodzaj = request.getParameter("rodzaj");
        String kapital = request.getParameter("kapital");
        String wlasciciel = request.getParameter("wlasciciel");

        producer2.sendMsg(nazwa, rodzaj, kapital, wlasciciel);

        response.sendRedirect("zad2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/zad2.xhtml");
        view.forward(request, response);
    }
}
