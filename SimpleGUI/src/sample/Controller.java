package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.text.Format;

public class Controller {

    public Controller()
    {
        //НИКАКИХ ОБРАЩЕНИЙ К ЭЛЕМЕНТАМ!
        /**/
    }

    @FXML
    public TextField aTextField, bTextField;
    @FXML
    public CheckBox floatCheckBox;
    @FXML
    public Label sumLabel,difLabel, mulLabel, divLabel, messageLabel;
    @FXML
    public RadioButton rb2, rb3, rb5;
    @FXML
    public HBox rbPanel;

    @FXML
    public ComboBox comboBox1;

    ObservableList<String> ol = FXCollections.observableArrayList();
    /*
        вызывается JavaFX после создания всех элементов интерфейса
     */
    @FXML
    public void initialize()
    {
        ToggleGroup tg = new ToggleGroup();
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb5.setToggleGroup(tg);

        ChangeListener<Boolean> cl = (a, b, c) ->
        {
            if(floatCheckBox.isSelected())
                calculate();
        };

        rb2.selectedProperty().addListener(cl);
        rb3.selectedProperty().addListener(cl);
        rb5.selectedProperty().addListener(cl);

        ChangeListener<Boolean> checkBoxListener = (a, oldValue, newValue) ->
        {
            rbPanel.setDisable(!newValue);
            calculate();
        };

        floatCheckBox.selectedProperty().addListener(checkBoxListener);
        //System.out.println(rb2.getText());


        //COMBOBOX

        ol.add("Клинтон");
        ol.add("Трамп");

        /*comboBox1.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                ListCell<String> listCell = new ComboBoxListCell<String>();
                listCell.setText("abc");

                return listCell;
            }
        });*/

        comboBox1.setItems(ol);
    }

    public void calculate()
    {
        //ol.add("abc");
        System.out.println(comboBox1.getSelectionModel().getSelectedItem());
        try {
            System.out.println( aTextField.getText() + " + " + bTextField.getText());

            if(!floatCheckBox.isSelected()) {

                int a = Integer.parseInt(aTextField.getText());
                int b = Integer.parseInt(bTextField.getText());
                sumLabel.setText(
                        (a + b) + ""
                );
                difLabel.setText(
                        (a - b) + ""
                );
                mulLabel.setText(
                        (a * b) + ""
                );
                divLabel.setText(
                        (a / b) + ""
                );
            }
            else
            {
                double a = Double.parseDouble(aTextField.getText());
                double b = Double.parseDouble(bTextField.getText());
                //Double d1, d2, d3, d4;
                String formatString = "";
                if(rb2.isSelected()) formatString = "%.2f";
                else if(rb3.isSelected())formatString = "%.3f";
                else formatString = "%.5f";

                sumLabel.setText(
                        String.format(formatString, (a + b))
                );
                difLabel.setText(
                        String.format(formatString, (a - b))
                );
                mulLabel.setText(
                        String.format(formatString, (a * b))
                );
                divLabel.setText(
                        String.format(formatString, (a / b))
                );
            }
        }
        catch (Exception e)
        {
            messageLabel.setText("Введите корректные значения!");
        }
    }
}
