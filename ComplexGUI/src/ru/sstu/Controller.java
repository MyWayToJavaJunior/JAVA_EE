package ru.sstu;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.sstu.components.MyPanel;
import ru.sstu.components.MyPanel2;
import ru.sstu.events.MyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Controller {


    private EventHandler<MyEvent> eh1;

    @FXML
    private HBox rootHBox;

    @FXML
    private VBox vBox1;

    MyPanel mp = new MyPanel();
    List<MyPanel> panels = new ArrayList<>();
    MyPanel2 mp2 = new MyPanel2();


    @FXML
    public void initialize()
    {
        for(int i = 0; i < 10; i++)
        {
            MyPanel myPanel = new MyPanel();
            myPanel.setButtonText("Кнопка " + (i+1));
            panels.add(myPanel);

            myPanel.addEventHandler(MyEvent.BAD_EVENT, (MyEvent event) -> System.out.println(":(("));
        }

        vBox1.getChildren().add(panels.get(0));

    }

    @FXML
    public void back()
    {
        Parent root;
        try {
            /*root = FXMLLoader.load(getClass().getResource("views/secondWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Новое окно");
            stage.setScene(new Scene(root, 450, 450));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();*/


            //swap();
            changePanel(false);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void forward()
    {
        changePanel(true);
    }

    public void changePanel(boolean isForward)
    {
        boolean flag = false;
        for(MyPanel m : panels)
        {
            for(Node n : vBox1.getChildren())
            {
                if(n.equals(m))
                {
                    int i = panels.indexOf(m);
                    if(
                            (i < panels.size()-1 && isForward) ||
                            (i > 0 && !isForward)
                            ) {

                        vBox1.getChildren().replaceAll(
                                (Node node) -> {
                                    if (node.equals(m))
                                        return panels.get(i + (isForward ? 1 : -1));
                                    return null;
                                });
                    }
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
    }

    public void swap()
    {
        if(vBox1.getChildren().contains(mp))
        {
            vBox1.getChildren().remove(mp);
            vBox1.getChildren().add(mp2);
        }
        else
        {
            vBox1.getChildren().remove(mp2);
            vBox1.getChildren().add(mp);
        }
    }
}
