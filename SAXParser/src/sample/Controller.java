package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    @FXML
    private HBox topHBox;
    @FXML
    private TextArea consoleTextArea;

    private List<Button> buttons = new ArrayList<>();

    private int buttonsCounter = 1;

    @FXML
    public void initialize() {

        addButton((event) ->
        {
            File f = new File("./albums.xml");
            if(!f.exists()) return;


            try {
                SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                SAXParser saxParser = saxParserFactory.newSAXParser();

                //DefaultHandler dh = new DefaultHandler();
                //MySAXHandler msh = new MySAXHandler();
                StackSAXHandler ssh = new StackSAXHandler();
                saxParser.parse(f, ssh);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    public void addButton(EventHandler<MouseEvent> handler) {
        Button b = new Button();
        b.setText("Кнопка " + (buttonsCounter++));
        topHBox.getChildren().add(b);
        b.setOnMouseClicked(handler);
    }

    public void print(String s) {
        consoleTextArea.appendText(s + "\n");
    }

}
