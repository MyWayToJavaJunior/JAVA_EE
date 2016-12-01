package ru.sstu;

import com.sun.net.httpserver.HttpsParameters;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestMethod("GET");
            String params = "date_req=30/11/2016";

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(params);

            dos.flush();
            dos.close();

            int status = conn.getResponseCode();
            if(status == HttpURLConnection.HTTP_OK)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line = br.readLine()) != null)
                {
                    System.out.println(line);
                }
                br.close();
            }
            else
            {
                System.out.println("ERROR");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
