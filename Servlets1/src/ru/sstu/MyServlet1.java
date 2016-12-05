package ru.sstu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Shvarts on 02.12.16.
 */
public class MyServlet1 extends HttpServlet {


    int counter = 0;

    public MyServlet1()
    {
        System.out.println("=================================================");
        System.out.println("CONSTRUCTOR");
        System.out.println("=================================================");
    }

    public void init()
    {
        System.out.println("=================================================");
        System.out.println("INIT");
        System.out.println("=================================================");

    }


    public void destroy()
    {
        System.out.println("=================================================");
        System.out.println("DESTROY");
        System.out.println("=================================================");
    }

    //GET - получение ресурса
    //POST - отправка данных на сервер (данные веб-формы, файл и т.д.)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();



        response.getWriter().write("<html><body>");
        response.getWriter().write("<h1>Hello, world!!!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>");
        response.getWriter().write("<h2>Counter = " + (counter++) +"</h2>");
        response.getWriter().write("<i>Message</i><br/>");
        for (Map.Entry<String, String[]> entry:
                params.entrySet()) {
            response.getWriter().write(entry.getKey() + " = ");
            for(String value : entry.getValue())
                response.getWriter().write(value + "  ");
            response.getWriter().write("<br/>");
        }

        String id = request.getParameter("id");
        if(id == null)
        {
            response.getWriter().write("id not specified!");
        }
        else response.getWriter().write("id=" + id);

        response.getWriter().write("</body></html>");
        //response.getWriter()
    }
}
