package ru.sstu;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            String xmlInputFile = "./albums.xml";
            Source xmlSource = new StreamSource(
                    new FileInputStream(xmlInputFile));

            String xsltInputFile = "./albums_5.xsl";
            Source xsltSource = new StreamSource(new FileInputStream(xsltInputFile));

            String xmlOutputFile = "./albums_result_1.html";
            Result transResult = new StreamResult(new FileOutputStream(xmlOutputFile));

            //transResult = new StreamResult(System.out);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer(xsltSource);

            t.transform(xmlSource, transResult);
        } catch (Exception ex) {
            ex.printStackTrace();
            //Logger.getLogger(Dom4Example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
