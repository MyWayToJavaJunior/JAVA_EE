package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Controller {
    @FXML
    private TextField queryTextField, pathTextField;

    @FXML
    private TextArea outTextArea, xmlTextArea, dirTextArea;
    Document doc, docFS;
    Element currentDir = null;
    XPathFactory factory = XPathFactory.newInstance();
    XPath xPath = factory.newXPath();

    @FXML
    public void initialize()
    {

        String pathToFile = "./albums.xml";
        try {

            List<String> lines = Files.readAllLines(Paths.get(pathToFile));
            lines.forEach((line) -> xmlTextArea.appendText(line + "\n"));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File file = new File(pathToFile);
            doc = builder.parse(file);


            File fileFS = new File("./FS.xml");
            docFS = builder.parse(fileFS);

            XPathExpression expr = xPath.compile("/root");
            currentDir = (Element) expr.evaluate(docFS, XPathConstants.NODE);

            expr = xPath.compile("/root/*");
            NodeList nodesInRoot = (NodeList) expr.evaluate(docFS, XPathConstants.NODESET);

            printChildren(nodesInRoot);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void executeQuery()
    {
        try {
            String query = queryTextField.getText();

            XPathExpression expr = xPath.compile(query);
            outTextArea.appendText("=======================\n");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            outTextArea.appendText(query  +"(" +nodes.getLength() +")"+"\n");

            for (int i = 0; i < nodes.getLength(); i++) {
                outTextArea.appendText(nodes.item(i).getNodeName() +":" + nodes.item(i).getTextContent() + "\n");
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void goBack()
    {
        try {
            if(currentDir.getNodeName().equals("root")) return;
            XPathExpression expr = xPath.compile("../*");
            NodeList children = (NodeList)expr.evaluate(currentDir, XPathConstants.NODESET);
            currentDir = (Element)children.item(0).getParentNode();
            System.out.println(".. = " + currentDir.getNodeName());
            printChildren(children);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void go()
    {

        try {
            String pathToGo = pathTextField.getText();
            XPathExpression expr = xPath.compile(pathToGo + "/*");
            NodeList children = (NodeList)expr.evaluate(currentDir, XPathConstants.NODESET);
            if(children.getLength() == 0) return;
            currentDir = (Element)children.item(0).getParentNode();
            System.out.println("child = " + currentDir.getNodeName());
            printChildren(children);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    public void printChildren(NodeList nodes)
    {
        dirTextArea.clear();
        for (int i = 0; i < nodes.getLength(); i++) {
            String nodeName = nodes.item(i).getNodeName();
            if(!nodeName.equals("file"))
            {
                dirTextArea.appendText(nodeName + "\n");
            }
        }
        for (int i = 0; i < nodes.getLength(); i++) {
            String nodeName = nodes.item(i).getNodeName();
            if (nodeName.equals("file")) {
                dirTextArea.appendText(
                        ((Element) nodes.item(i)).getAttribute("name") + "\n"
                );
            }
        }
    }

}
