package ru.sstu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Shvarts on 05.12.16.
 */
public class AboutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        RequestDispatcher rd2 = request.getRequestDispatcher("hat.html");
        RequestDispatcher rd1= request.getRequestDispatcher("/pageStart");

        request.setAttribute("title", "О нас");

        rd1.include(request, response);
        rd2.include(request, response);

        response.getWriter().write("<h1>О нас!</h1>");
        Date date = new Date();
        response.getWriter().write("<p>toString() = " + date + "</p>");
        response.getWriter().write("<p>getTime() = " + date.getTime() + "</p>");
        response.getWriter().write("<p>seconds = " + date.getTime()/1000 + "</p>");
        response.getWriter().write("<p>minutes= " + date.getTime()/1000/60 + "</p>");
        response.getWriter().write("<p>hours= " + date.getTime()/1000/60/60 + "</p>");
        response.getWriter().write("<p>days= " + date.getTime()/1000/60/60/24 + "</p>");
        response.getWriter().write("<p>weeks= " + date.getTime()/1000/60/60/24/7 + "</p>");
        response.getWriter().write("<p>years= " + date.getTime()/1000/60/60/24/365 + "</p>");


        response.getWriter().write("<h1>Так удобнее:</h1>");

        DateFormat df = DateFormat.getDateInstance();
        response.getWriter().write("<p>dateFormatClass = " + df.getClass().getName() + "</p>");
        response.getWriter().write("<p>formatted date (current locale) = " + df.format(date) + "</p>");

        DateFormat df2 = DateFormat.getDateInstance(0, Locale.US);
        response.getWriter().write("<p>formatted date (USA) = " + df2.format(date) + "</p>");

        DateFormat df3 = DateFormat.getDateInstance(1);
        response.getWriter().write("<p>dateFormatClass = " + df3.getClass().getName() + "</p>");
        response.getWriter().write("<p>formatted date (current locale) = " + df3.format(date) + "</p>");

        DateFormat df4 = DateFormat.getDateInstance(2);
        response.getWriter().write("<p>dateFormatClass = " + df4.getClass().getName() + "</p>");
        response.getWriter().write("<p>formatted date (current locale) = " + df4.format(date) + "</p>");


        DateFormat df5 = DateFormat.getDateInstance(3);
        response.getWriter().write("<p>dateFormatClass = " + df5.getClass().getName() + "</p>");
        response.getWriter().write("<p>formatted date (current locale) = " + df5.format(date) + "</p>");

        /*DateFormat df6 = DateFormat.getDateInstance(4);//no 4!!!!!!!!!!!
        response.getWriter().write("<p>dateFormatClass = " + df6.getClass().getName() + "</p>");
        response.getWriter().write("<p>formatted date (current locale) = " + df6.format(date) + "</p>");*/

        response.getWriter().write("<h1>Так удобнее (c заданным форматом):</h1>");

        SimpleDateFormat sfd = new SimpleDateFormat("d-M-y");
        response.getWriter().write("<p>d-M-y = " + sfd.format(date) + "</p>");



        SimpleDateFormat sfd1 = new SimpleDateFormat("M");
        response.getWriter().write("<p>M = " + sfd1.format(date) + "</p>");
        SimpleDateFormat sfd2 = new SimpleDateFormat("m");
        response.getWriter().write("<p>m = " + sfd2.format(date) + "</p>");
        SimpleDateFormat sfd3 = new SimpleDateFormat("h:m:s");
        response.getWriter().write("<p>h:m:s = " + sfd3.format(date) + "</p>");
        SimpleDateFormat sfd4 = new SimpleDateFormat("Y");
        response.getWriter().write("<p>Y= " + sfd4.format(date) + "</p>");
        SimpleDateFormat sfd5 = new SimpleDateFormat("yy");
        response.getWriter().write("<p>yy= " + sfd5.format(date) + "</p>");

        SimpleDateFormat sfd6 = new SimpleDateFormat("h:m:s a");
        response.getWriter().write("<p>h:m:s a = " + sfd6.format(date) + "</p>");


        Date date2 = new Date(date.getTime()/2);
        response.getWriter().write("<p>ms = " + 5 * 30 * 24 * 3600 * 1000 + "</p>");
        SimpleDateFormat sfd7 = new SimpleDateFormat("d MMM y");
        response.getWriter().write("<p>d MMM y = " + sfd7.format(date2) + "</p>");
        SimpleDateFormat sfd8 = new SimpleDateFormat("d MMMM y");
        response.getWriter().write("<p>d MMMM y = " + sfd8.format(date2) + "</p>");
        SimpleDateFormat sfd9 = new SimpleDateFormat("d MM y");
        response.getWriter().write("<p>d MM y = " + sfd9.format(date2) + "</p>");
        SimpleDateFormat sfd10 = new SimpleDateFormat("d M y");
        response.getWriter().write("<p>d M y = " + sfd10.format(date2) + "</p>");
       //FIXME timezones!!!


        //df7.s


        response.getWriter().write("</body></html>");
    }
}
