package ru.sstu;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by user on 09.12.2016.
 */
public class RoutingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        String URI = request.getRequestURI();
        if(URI.startsWith("/private"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/accessDenied.jsp");
            rd.forward(req, resp);
        }
        else {
            if (URI.endsWith(".html")) {
                String newURI = URI.replace(".html", "");
                RequestDispatcher rd = request.getRequestDispatcher(newURI);
                rd.forward(req, resp);
            } else {

                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
