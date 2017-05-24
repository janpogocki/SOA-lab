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
@WebServlet(name = "ServletBookAdd", urlPatterns = "bookAdd")
public class ServletBookAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        int yearOfRelease = Integer.parseInt(request.getParameter("yearOfRelease"));
        Double price = Double.parseDouble(request.getParameter("price"));

        BooksEntity booksEntity = new BooksEntity();
        booksEntity.setSurname(surname);
        booksEntity.setName(name);
        booksEntity.setTitle(title);
        booksEntity.setIsbn(isbn);
        booksEntity.setYearOfRelease(yearOfRelease);
        booksEntity.setPrice(price);

        TableSQL tableSQL = new TableSQL();
        tableSQL.saveBook(booksEntity);

        response.sendRedirect("index.jsp");
    }
}
