package com.parking.system;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 17.06.2017.
 */
@WebServlet(name = "ServletWatchdog", urlPatterns = "/RunWatchdog")
public class ServletWatchdog extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Watchdog watchdog = new Watchdog();
                watchdog.start();
            }
        };

        thread.start();

        response.sendRedirect("./dashboard/");
    }
}
