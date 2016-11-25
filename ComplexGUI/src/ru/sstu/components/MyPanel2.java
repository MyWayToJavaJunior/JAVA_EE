package ru.sstu.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Shvarts on 18.11.2016.
 */
public class MyPanel2 extends AnchorPane {

    @FXML
    public void clickButton()
    {
        System.out.println("CLICK 2!!!");
    }


    public MyPanel2()
    {
        super();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/myPanel2.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
