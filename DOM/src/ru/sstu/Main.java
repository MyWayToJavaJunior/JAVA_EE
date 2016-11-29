package ru.sstu;

import com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            File file = new File("./albums.xml");

            Document doc = builder.parse(file);
            System.out.println("Success!");
            System.out.println(doc.getClass().getCanonicalName());
            //printDoc(doc);
            //printChildren(doc.getChildNodes().item(1));
            //printTree(doc);

            /*Node albums = doc.getChildNodes().item(1);
            Node album = albums.getChildNodes().item(3);
            Node artists = album.getChildNodes().item(9);
            Node artist = artists.getChildNodes().item(1);
            printRoute(artist);*/


            //doc.getElementsByTagName()
            //printAllByName("name", doc);

            //modifyDocument3(doc);
            //saveDocToFile(doc);
            createDocument();
            //modifyDocument4(doc);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printDoc(Document doc)
    {
        NodeList nodes = doc.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("NODE #" + (i+1));
            System.out.println("Node name = " + nodes.item(i).getNodeName());
            System.out.println("Node value = " + nodes.item(i).getNodeValue());
            System.out.println("Node type = " + nodes.item(i).getNodeType());
            System.out.println("Node text content = " + nodes.item(i).getTextContent());
            if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println("TAG!");
            }

        }
    }

    public static void printTree(Node node)
    {
        NodeList nodes = node.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node child = nodes.item(i);
            System.out.println("Value = " + child.getNodeValue());
            if(child.getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println(child.getNodeName());
                NamedNodeMap atts = child.getAttributes();
                for (int j = 0; j < atts.getLength(); j++) {
                    Node attNode = atts.item(j);
                    Attr attribute = (Attr)attNode;
                    System.out.println(attribute.getName() + " = " + attribute.getValue());
                }
                printTree(nodes.item(i));
            }

        }
    }

    public static void printChildren(Node node)
    {

        System.out.println(node.getNodeName() + "'s children:");
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            System.out.println("#" + i);
            System.out.println(children.item(i).getNodeName());
            //System.out.println("Node value = " + children.item(i).getNodeValue());
            //System.out.println("Node text content = " + children.item(i).getTextContent());
        }
    }

    public static void printRoute(Node node)
    {
        //StringBuilder sb = new StringBuilder(node.getNodeName());
        String s = node.getNodeName();
        while(true)
        {
            Node parent = node.getParentNode();
            if(parent == null) break;
            //sb.append(parent.getNodeName()).append("/");
            s = parent.getNodeName() + "/" + s;
            node = parent;
        }
        System.out.println(s);
    }

    public static void printAllByName(String nodeName, Document doc)
    {
        NodeList elements = doc.getElementsByTagName(nodeName);
        for (int i = 0; i < elements.getLength(); i++) {
            Node child = elements.item(i);
            System.out.println(i + " = " + child.getNodeName());



        }
    }

    public static void modifyDocument1(Document doc)//НЕКОРРЕКТНО
    {
        Node albums = doc.getElementsByTagName("albums").item(0);

        NodeList children = albums.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            System.out.println("Total: " + children.getLength());
            System.out.println("i: " + i + ", " + children.item(i).getNodeName());
            albums.removeChild(children.item(i));
            System.out.println("Total: " + children.getLength());
        }
    }

    public static void modifyDocument2(Document doc)
    {
        Node albums = doc.getElementsByTagName("albums").item(0);
        NodeList children = albums.getChildNodes();
        while(children.getLength() > 0)
        {
            System.out.println("ITERATION");
            System.out.println("Total: " + children.getLength());
            System.out.println(children.item(0).getNodeName());
            albums.removeChild(children.item(0));
            System.out.println("Total after removal: " + children.getLength());
        }
    }

    public static void modifyDocument3(Document doc)
    {
        Node albums = doc.getElementsByTagName("albums").item(0);

        Element album = doc.createElement("album");
        Element name = doc.createElement("name");
        Text t = doc.createTextNode("Альбом c красивым названием!");

        album.appendChild(name);
        name.appendChild(t);
        albums.appendChild(album);


    }

    public static void modifyDocument4(Document doc)
    {
        NodeList tracks = doc.getElementsByTagName("tracks");
        Node tracks1 = tracks.item(0);
        Node tracks2 = tracks.item(1);

        NodeList track = doc.getElementsByTagName("track");
        Node track1 = track.item(0);


        tracks2.appendChild(track1);
        //tracks1.removeChild(track1);
        saveDocToFile(doc);


    }

    public static void createDocument()
    {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            Document doc = builder.newDocument();

            Element rootNode = doc.createElement("root");

            Attr id = doc.createAttribute("id");
            id.setValue("uniqueID123456784");

            rootNode.setAttributeNode(id);

            rootNode.setAttribute("width", "150");

            doc.appendChild(rootNode);
            saveDocToFile(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void saveDocToFile(Document doc)
    {
        try {
            File file = new File("./" + System.currentTimeMillis() + ".xml");

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            DOMSource source = new DOMSource(doc);


            StreamResult sr = new StreamResult(file);

            t.transform(source, sr);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }


}
