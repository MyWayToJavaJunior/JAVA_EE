package ru.sstu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Shvarts on 07.12.16.
 */
public class I18NServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.addHeader("Content-Type", "text/html; charset=utf-8");
        String[] timeZoneIDs = TimeZone.getAvailableIDs();
        PrintWriter pw = response.getWriter();
        /*for (String tzid : timeZoneIDs) {
            pw.write(tzid + "<br/>");
        }*/

        pw.write("<h1>Current:</h1>");
        TimeZone tz = TimeZone.getDefault();
        pw.write("id = " + tz.getID()+"<br/>");
        pw.write("displayName = " + tz.getDisplayName()+"<br/>");
        pw.write("offset = " + tz.getRawOffset()/1000/60/60+"<br/>");

        pw.write("<h1>New York:</h1>");
        TimeZone tz2 = TimeZone.getTimeZone("America/New_York");
        pw.write("id = " + tz2.getID()+"<br/>");
        pw.write("displayName = " + tz2.getDisplayName()+"<br/>");
        pw.write("offset = " + tz2.getRawOffset()/1000/60/60+"<br/>");



        pw.write("<h1>Calendar:</h1>");
        Calendar c = new GregorianCalendar();
        printCalendar(c, pw);

        pw.write("<h1>Calendar 2:</h1>");
        Calendar c2 = new GregorianCalendar(2016, 0, 1, 13, 15);
        printCalendar(c2, pw);


        pw.write("<h1>Number Format:</h1>");

        pw.write("<h2>Integer:</h2>");
        printInt(-7, pw);
        printInt(-70453464545l, pw);
        printInt(386767779345l, pw);

        pw.write("<h2>Double:</h2>");
        printDouble(8.378685, pw);
        printDouble(-4577768.3784365685, pw);
        printDouble(-0.3, pw);

        pw.write("<h2>Currency:</h2>");
        printCurrency(8.378685, pw);
        printCurrency(-4577768.3784365685, pw);
        printCurrency(-0.3, pw);

        pw.write("<h2>Number Parsing:</h2>");

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

        try {
            pw.write(nf.parse("$123,456.789")+"</br>");
        } catch (ParseException e) {
            pw.write("Error!<br/>");
        }
        try {
        pw.write(nf.parse("$123.456,789")+"</br>");} catch (ParseException e) {
            pw.write("Error!<br/>");
        }

            try {pw.write(nf.parse("$123 456 789")+"</br>");} catch (ParseException e) {
            pw.write("Error!<br/>");
        }

                try {pw.write(nf.parse("$123abc")+"</br>");} catch (ParseException e) {
            pw.write("Error!<br/>");
        }
                    try {pw.write(nf.parse("$abc123")+"</br>");} catch (ParseException e) {
            pw.write("Error!<br/>");
        }



        pw.write("<h1>DateFormat + Locale:</h1>");
        SimpleDateFormat sdf1 = new SimpleDateFormat("d MMMM Y");
        SimpleDateFormat sdf2 = new SimpleDateFormat("d MMMM Y", Locale.US);
        SimpleDateFormat sdf3 = new SimpleDateFormat("d MMMM Y", Locale.GERMANY);
        printDate(sdf1, pw);
        printDate(sdf2, pw);
        printDate(sdf3, pw);

        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALIAN);
        printDate(df1, pw);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.ITALIAN);
        printDate(df2, pw);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALIAN);
        printDate(df3, pw);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALIAN);
        printDate(df4, pw);

        /*pw.write("<h1>Locale:</h1>");
        pw.write("<h2>Default:</h2>");
        Locale l1 = Locale.getDefault();
        printLocale(l1, pw);

        pw.write("<h2>USA:</h2>");
        Locale l2 = Locale.US;
        printLocale(l2, pw);

        pw.write("<h2>German:</h2>");
        Locale l3 = Locale.GERMAN;
        printLocale(l3, pw);

        pw.write("<h2>Germany:</h2>");
        Locale l4 = Locale.GERMANY;
        printLocale(l4, pw);

        pw.write("<h2>UK:</h2>");
        Locale l5 = new Locale("en", "UK", "Latn");
        printLocale(l5, pw);

        pw.write("<h2>Custom:</h2>");
        Locale l6 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        printLocale(l6, pw);

        pw.write("<h1>Resources:</h1>");
        ResourceBundle rb1 = ResourceBundle.getBundle("ru.sstu.messages");
        pw.write("<h2>" + rb1.getString("hello") + "</h2>");
        printResourceBundle(rb1, pw);

        pw.write("<h2>en:</h2>");
        ResourceBundle rb2 = ResourceBundle.getBundle("ru.sstu.messages", Locale.UK);
        printResourceBundle(rb2, pw);

        pw.write("<h2>de:</h2>");
        ResourceBundle rb3 = ResourceBundle.getBundle("ru.sstu.messages", Locale.GERMANY);
        printResourceBundle(rb3, pw);

        pw.write("<h2>ru:</h2>");
        ResourceBundle rb4 = ResourceBundle.getBundle("ru.sstu.messages", new Locale("ru"));
        printResourceBundle(rb4, pw);

        pw.write("<h2>ca:</h2>");
        ResourceBundle rb5 = ResourceBundle.getBundle("ru.sstu.messages", Locale.CANADA_FRENCH);
        printResourceBundle(rb5, pw);*/

    }

    public void printResourceBundle(ResourceBundle rb, PrintWriter pw)
    {
        Enumeration<String> en = rb.getKeys();
        while(en.hasMoreElements())
        {
            String key = en.nextElement();
            pw.write(key + " = " + rb.getString(key) + "<br/>");
        }
    }

    public void printCalendar(Calendar c, PrintWriter pw)
    {
        pw.write("era = " + c.get(Calendar.ERA)+"<br/>");
        pw.write("year = " + c.get(Calendar.YEAR)+"<br/>");
        pw.write("month = " + c.get(Calendar.MONTH)+"<br/>");
        pw.write("week of year= " + c.get(Calendar.WEEK_OF_YEAR)+"<br/>");
        pw.write("week of month= " + c.get(Calendar.WEEK_OF_MONTH)+"<br/>");
        pw.write("day of month= " + c.get(Calendar.DAY_OF_MONTH)+"<br/>");
        pw.write("day of week= " + c.get(Calendar.DAY_OF_WEEK)+"<br/>");
        pw.write("day of year = " + c.get(Calendar.DAY_OF_YEAR)+"<br/>");
        pw.write("hour = " + c.get(Calendar.HOUR)+"<br/>");
        pw.write("hour of the day = " + c.get(Calendar.HOUR_OF_DAY)+"<br/>");
        pw.write("minute = " + c.get(Calendar.MINUTE)+"<br/>");
        pw.write("second = " + c.get(Calendar.SECOND)+"<br/>");
        pw.write("AM/PM= " + c.get(Calendar.AM_PM)+"<br/>");
    }

    public void printInt(long i, PrintWriter pw)
    {
        pw.write(i + "<br/>");
        NumberFormat nf1 = NumberFormat.getIntegerInstance();
        pw.write(nf1.format(i)+"<br/>");

        NumberFormat nf2 = NumberFormat.getIntegerInstance(Locale.US);
        pw.write(nf2.format(i)+"<br/>");


    }

    public void printDouble(double i, PrintWriter pw)
    {
        pw.write(i + "<br/>");
        NumberFormat nf1 = NumberFormat.getNumberInstance();
        pw.write(nf1.format(i)+"<br/>");

        NumberFormat nf2 = NumberFormat.getNumberInstance(Locale.US);
        pw.write(nf2.format(i)+"<br/>");
    }

    public void printCurrency(double i, PrintWriter pw)
    {
        pw.write(i + "<br/>");
        NumberFormat nf1 = NumberFormat.getCurrencyInstance();
        pw.write(nf1.format(i)+"<br/>");

        NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.US);
        pw.write(nf2.format(i)+"<br/>");
    }

    public void printLocale(Locale l, PrintWriter pw)
    {
        pw.write("country = " + l.getCountry()+"<br/>");
        pw.write("lang = " + l.getLanguage()+"<br/>");
        pw.write("name = " + l.getDisplayName()+"<br/>");
    }

    public void printDate(DateFormat df, PrintWriter pw)
    {
        pw.write(df.format(new Date()) + "<br/>");
    }
}
