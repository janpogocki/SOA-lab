package com.example.Zadanie1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jan on 28.03.2017.
 */
@WebServlet(name = "Servlet_Zadanie1")
public class Servlet_Zadanie1 extends HttpServlet {

    UsersBean usersBean = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date_ = new Date();
        String date = dateFormat.format(date_);

        session.setAttribute("logged_user", login);
        session.setAttribute("logged_user_date", date);

        if (usersBean == null)
            usersBean = new UsersBean(login, date);
        else
            usersBean.addUser(login, date);

        response.sendRedirect("Zadanie1.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("Logout").equals("")) {
            String login = session.getAttribute("logged_user").toString();
            String date = session.getAttribute("logged_user_date").toString();
            usersBean.deleteUser(login, date);

            session.invalidate();
            response.sendRedirect("Zadanie1.jsp");
        }


    }
}
