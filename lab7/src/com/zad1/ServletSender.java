package com.zad1;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 03.05.2017.
 */
@WebServlet(urlPatterns = "/zad1")
public class ServletSender extends HttpServlet {
    @EJB
    Producer1 producer1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        producer1.sendMsg(request.getParameter("text"), request.getParameter("type"), request.getParameter("topic"));
        response.getWriter().write("Wiadomosc zostala wyslana!");
    }
}
