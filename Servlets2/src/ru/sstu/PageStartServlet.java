package ru.sstu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shvarts on 05.12.16.
 */
public class PageStartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String title = (String) request.getAttribute("title");
        if(title == null) title = "My Application";
        response.getWriter().write("<!DOCTYPE html><html><head><title>" + title + "</title></head><body>");
    }
}
