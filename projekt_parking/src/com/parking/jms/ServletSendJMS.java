package com.parking.jms;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 17.06.2017.
 */
@WebServlet(name = "ServletSendJMS", urlPatterns = "/ServletSendJMS")
public class ServletSendJMS extends HttpServlet {
    @EJB
    TicketProducer ticketProducer;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ticketProducer.sendMsg(request.getParameter("carid"), request.getParameter("strefa"), request.getParameter("miejsce"));
        response.getWriter().write("Wiadomosc zostala wyslana!");
    }
}
