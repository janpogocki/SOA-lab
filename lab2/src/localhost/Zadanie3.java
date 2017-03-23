package localhost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Jan on 16.03.2017.
 * Napisz servlet, który będzie przyjmował 5 liczb całkowitych metodą GET, wyliczy ich średnią i zwróci
 wynik.

 * Napisz servlet, który będzie przyjmował dowolną ilość parametrów metodą POST i sprawdzał, czy
 parametry te są liczbami. Jeśli są, niech je wyświetli w kolejności od najmniejszej do największej.
 Jeśli parametry nie są liczbami, niech servlet zwróci informacje o błędnych danych.
 */

@WebServlet(name = "Zadanie3")
public class Zadanie3 extends HttpServlet {
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vector<Integer> wektor = new Vector<>();

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Boolean isAllIntegers = true;

        for (String liczba : request.getParameterMap().keySet()) {
            if (isInteger(request.getParameter(liczba))){
                wektor.add(Integer.parseInt(request.getParameter(liczba)));
            }
            else {
                isAllIntegers = false;
                break;
            }
        }

        if (isAllIntegers){
            Collections.sort(wektor);

            for (Integer number : wektor)
                out.println(number + "<br>");
        }
        else {
            out.println("Podano błędne dane!");
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int suma = 0;
        int liczbaParametrow = 0;

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        for (String liczba : request.getParameterMap().keySet()) {
            suma = suma + Integer.parseInt(request.getParameter(liczba));
            liczbaParametrow++;
        }

        out.println(String.valueOf(suma/liczbaParametrow));

        out.close();
    }
}
