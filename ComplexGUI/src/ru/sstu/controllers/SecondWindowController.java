package ru.sstu.controllers;

import javafx.fxml.FXML;

/**
 * Created by Shvarts on 18.11.2016.
 */
public class SecondWindowController {
    @FXML
    public void initialize()
    {
        System.out.println("INITED!");
    }
    @FXML
    public void clickButton()
    {
        System.out.println("Button clicked!");
    }
}
