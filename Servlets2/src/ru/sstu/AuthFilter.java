package ru.sstu;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shvarts on 05.12.16.
 */
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        //resp.getWriter().write("URL= " + request.getRequestURI() + "<br/>");

        HttpServletResponse response = (HttpServletResponse) resp;

        response.addHeader("Content-Type", "text/html; charset=utf-8");// a bit wrong!!!
        boolean authorized = checkAuthorization(req, resp);
        boolean toLoginPages = request.getRequestURI().equals("/login.html") || request.getRequestURI().equals("/auth");

        if( (authorized && !toLoginPages) || (!authorized && toLoginPages))
        {
            chain.doFilter(req, resp);
        }
        else
        {
            String forwardPath = "/about";
            if(!authorized)  forwardPath = "login.html";
            RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
            rd.forward(req, resp);
        }
    }

    private boolean checkAuthorization(ServletRequest req, ServletResponse resp) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                //resp.getWriter().write(c.getName() + " = " + c.getValue() + "<br/>");
                if (c.getName().equals("authorized") && c.getValue().equals("1")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
