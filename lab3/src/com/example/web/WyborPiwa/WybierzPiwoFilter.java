package com.example.web.WyborPiwa;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;

/**
 * Created by Jan on 27.03.2017.
 */
@WebFilter(filterName = "WybierzPiwoFilter")
public class WybierzPiwoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String rokUrodzeniaStr = req.getParameter("rok_urodzenia");
        int rokUrodzenia;

        if (rokUrodzeniaStr != null) {
            rokUrodzenia = Integer.parseInt(rokUrodzeniaStr);

            if (Integer.parseInt(Year.now().toString()) - rokUrodzenia < 18) {
                resp.setContentType("text/html; charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("Dzieciom nie wolno pić alkoholu!");
                out.close();
                return;
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
