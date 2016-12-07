package ru.sstu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shvarts on 05.12.16.
 */
public class ContactsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd2 = request.getRequestDispatcher("hat.html");
        RequestDispatcher rd1= request.getRequestDispatcher("/pageStart");

        request.setAttribute("title", "Contacts");

        rd1.include(request, response);
        rd2.include(request, response);

        response.getWriter().write("<h1>Contacts!</h1>");
        response.getWriter().write("</body></html>");
    }
}
