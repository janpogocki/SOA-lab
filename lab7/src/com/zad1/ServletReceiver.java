package com.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 03.05.2017.
 */
@WebServlet(urlPatterns = "/zad1rec")
public class ServletReceiver extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String topicName = request.getParameter("topic");

        String toShow = Storage.getMessages(type, topicName);
        response.getWriter().write(toShow);
    }
}
