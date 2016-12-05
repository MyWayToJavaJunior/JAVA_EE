package ru.sstu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Shvarts on 02.12.16.
 */
@WebServlet(name = "YourServlet")
public class YourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.getWriter().write("<html><body>");

        boolean correctPassword = false;
        if(request.getParameter("password") != null) {

            if(request.getParameter("password").equals("123456")) {
                correctPassword = true;
                Date d = new Date();

                Cookie cookie = new Cookie("login_time", System.currentTimeMillis()+"");
                response.addCookie(cookie);

                Cookie cookie2 = new Cookie("real_user", "1");
                response.addCookie(cookie2);

                response.getWriter().write("Congratulations! You have logged in!<br/>");
            }
            else response.getWriter().write("Password is not correct<br/>");
        }


            Cookie[] requestCookies = request.getCookies();
            boolean realUser = false;
            String loginTime = "";
            for (Cookie reqCookie:
                    requestCookies) {
                if(reqCookie.getName().equals("real_user") && reqCookie.getValue().equals("1"))
                {
                    realUser = true;
                    break;
                }
                else if(reqCookie.getName().equals("login_time"))
                {
                    loginTime = reqCookie.getValue();
                }
            }
            if(realUser)
            {
                response.getWriter().write("Hello, friend! You logged in at " + loginTime + "<br/>");
            }
            if(!realUser && !correctPassword)
                response.getWriter().write("Please, log in!<br/>");



        response.getWriter().write("</body></html>");
    }
}
