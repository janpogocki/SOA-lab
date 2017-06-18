package com.parking.system;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jan on 17.06.2017.
 */
@WebFilter(filterName = "FilterBrowser", urlPatterns = {"/dashboard/*"})
public class FilterBrowser implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String userAgent = ((HttpServletRequest) req).getHeader("User-Agent");

        if (userAgent.contains("Chrome")){
            chain.doFilter(req, resp);
            return;
        }

        ((HttpServletResponse) resp).getWriter().write("Brak dostepu");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
