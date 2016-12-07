package ru.sstu;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shvarts on 05.12.16.
 */
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = null, password = null;

        login = request.getParameter("login");
        password = request.getParameter("pass");

        if(login != null && password != null)
        {
            if(login.equals("admin") && password.equals("123456"))
            {
                Cookie c = new Cookie("authorized", "1");
                //c.setMaxAge(1);// FIXME !!!
                response.addCookie(c);

                response.getWriter().write("Welcome!");
                return;
            }
        }

        response.getWriter().write("Authorize!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
