package ru.sstu;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Controller {


    private ObservableList<Good> goods = FXCollections.observableArrayList();
    ChangeListener<String> priceTextListener;
    ChangeListener<Number> priceSliderListener;

    private boolean inEditingMode = false;

    @FXML
    private TableView<Good> goodsTable;
    @FXML
    private Button addButton;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextArea nameTextArea;
    @FXML
    private Slider priceSlider;

    @FXML
    private TableColumn<Good, String> idColumn, nameColumn, priceColumn;


    @FXML
    public void initialize()
    {
        goods.add(new Good(1, "Яблоко", 5.6f));
        goods.add(new Good(2, "Груша", 15.6f));
        goods.add(new Good(3, "Арбуз", 155.6f));

        goodsTable.setItems(goods);

        idColumn.setCellValueFactory(new PropertyValueFactory<Good, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Good, String>("price"));

        goodsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Good>() {
            @Override
            public void changed(ObservableValue<? extends Good> observable, Good oldValue, Good newValue) {

                if(newValue != null)
                {
                    inEditingMode = true;

                    updateForm(newValue);
                    addButton.setText("Сохранить");
                }
                else
                {
                    inEditingMode = false;
                    nameTextArea.clear();
                    priceSlider.setValue(priceSlider.getMin());
                    addButton.setText("Добавить");
                }
            }
        });

        nameColumn.setCellFactory(
                TextFieldTableCell.forTableColumn()
        );
        nameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Good, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Good, String> event) {
                int rowIndex = event.getTablePosition().getRow();
                Good editedGood = goodsTable.getItems().get(rowIndex);
                editedGood.setName(event.getNewValue());
                updateForm(editedGood);
            }
        });


        priceTextListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    float f = Float.parseFloat(newValue);
                    priceSlider.valueProperty().removeListener(priceSliderListener);
                    priceSlider.setValue(f);
                    priceSlider.valueProperty().addListener(priceSliderListener);
                }
                catch(Exception e){}
            }
        };
        priceSliderListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue != null) {

                    priceTextField.textProperty().removeListener(priceTextListener);
                    priceTextField.setText(floatToString(newValue.floatValue()));
                    priceTextField.textProperty().addListener(priceTextListener);
                }

            }
        };
        priceSlider.valueProperty().addListener(priceSliderListener);

        priceTextField.textProperty().addListener(priceTextListener);

    }

    @FXML
    public void addGood()
    {
        Good selectedGood = goodsTable.getSelectionModel().getSelectedItem();
        if(!inEditingMode) {
            //add
            Good newGood = new Good();
            int maxID = 0;
            for (Good g : goods) {
                if (g.getId() > maxID) maxID = g.getId();
            }
            newGood.setId(maxID + 1);
            newGood.setName(nameTextArea.getText());
            newGood.setPrice((float) priceSlider.getValue());
            goods.add(newGood);
            addButton.setText("Сохранить");
            inEditingMode = true;
            goodsTable.getSelectionModel().select(newGood);
        }
        else
        {
            //save
            selectedGood.setName(nameTextArea.getText());
            selectedGood.setPrice((float)priceSlider.getValue());
            goodsTable.refresh();
            inEditingMode = false;
            addButton.setText("Добавить");
        }
    }

    @FXML
    public void deleteGood()
    {
        Good selectedGood = goodsTable.getSelectionModel().getSelectedItem();
        if(selectedGood != null )
        {
            goods.remove(selectedGood);
            inEditingMode = false;

        }

    }

    private void updateForm(Good g)
    {
        nameTextArea.setText(g.getName());
        priceTextField.setText(floatToString(g.getPrice()));

    }

    private String floatToString(float f)
    {
        return (Math.ceil(f*100)/100.0) + "";
    }
}
