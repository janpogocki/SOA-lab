package com.lab8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 24.05.2017.
 */
@WebServlet(name = "ServletBookDelete", urlPatterns = "bookDelete")
public class ServletBookDelete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idToDel = Integer.parseInt(request.getParameter("id"));

        TableSQL tableSQL = new TableSQL();
        tableSQL.deleteBook(idToDel);

        response.sendRedirect("index.jsp");
    }
}
