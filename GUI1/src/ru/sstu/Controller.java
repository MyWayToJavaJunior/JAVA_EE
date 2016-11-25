package ru.sstu;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    @FXML
    private VBox vBox;

    private List<Button> buttons = new LinkedList<>();

    EventHandler<MyEvent> handlerInClassField;

    @FXML
    public void initialize() {
        EventHandler<MyEvent> handler1 = new EventHandler<MyEvent>() {
            @Override
            public void handle(MyEvent event) {
                System.out.println("Обработчик 1");
                System.out.println(((Button) (event.getSource())).getText() + " обработала хорошее событие! Первоисточник: " + ((Button)(event.getOrigin())).getText());
            }
        };
        EventHandler<MyEvent> handler2 = new EventHandler<MyEvent>() {
            @Override
            public void handle(MyEvent event) {
                System.out.println("Обработчик 2");
                System.out.println(((Button) (event.getSource())).getText() + " обработала хорошее событие! Первоисточник: " + ((Button)(event.getOrigin())).getText());
                System.out.println("Передаем событие всем остальным...");
                for (Button b : buttons) {
                    if(!b.equals((Button) (event.getSource()))) {
                        b.removeEventHandler(MyEvent.GOOD, handlerInClassField);
                        b.fireEvent(event);
                        b.addEventHandler(MyEvent.GOOD, handlerInClassField);
                    }
                }
            }
        };
        handlerInClassField = handler2;
        for (int i = 0; i < 10; i++) {
            Button b = new Button();
            b.setText("Кнопка " + (i + 1));
            buttons.add(b);
            vBox.getChildren().add(b);
            b.addEventHandler(MyEvent.GOOD, handler1);
            b.addEventHandler(MyEvent.GOOD, handler2);
            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Button b = (Button)(event.getSource());
                    System.out.println("Кнопка '" + b.getText() + "' кликнута");
                    b.fireEvent(new MyEvent(b, MyEvent.GOOD));
                }
            });

        }
    }
}
