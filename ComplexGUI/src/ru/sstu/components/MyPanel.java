package ru.sstu.components;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import ru.sstu.events.MyEvent;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Shvarts on 18.11.2016.
 */
public class MyPanel extends AnchorPane {

    @FXML
    private Button btn1;

    private String buttonText;

    @FXML
    public void clickButton()
    {
        System.out.println("CLICK!!!");

        Random r = new Random();
        MyEvent me = null;
        if(r.nextBoolean())
        {
            me = new MyEvent(MyEvent.BAD_EVENT);
        }
        else
        {
            if(r.nextBoolean())
            {
                me = new MyEvent(MyEvent.GOOD_EVENT);
            }
            else me = new MyEvent(MyEvent.SUPER_GOOD_EVENT);

        }
        fireEvent(me);
        //Event e = new Event(Event.ANY);


    }


    public MyPanel()
    {
        super();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/myPanel.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize()
    {
        btn1.setText(getButtonText());

    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
        btn1.setText(getButtonText());
    }
}
