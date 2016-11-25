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

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    @FXML
    private HBox topHBox;
    @FXML
    private TextArea consoleTextArea;
    @FXML
    private ComboBox<String> classComboBox, methodComboBox;

    private Class chosenClass = null;
    private Method chosenMethod = null;


    private List<Button> buttons = new ArrayList<>();

    private int buttonsCounter = 1;

    @FXML
    public void initialize() {

        classComboBox.getItems().add("Animal");
        classComboBox.getItems().add("Person");


        classComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                methodComboBox.getItems().clear();

                try {
                    chosenClass = Class.forName(
                            this.getClass().getPackage().getName()
                                    + "."
                                    + newValue);
                    Method[] methods = chosenClass.getMethods();

                    Method[] objectMethods = Object.class.getMethods();

                    for (Method m : methods) {
                        if (m.getParameterCount() == 0) {
                            boolean flag = false;
                            for(Method mo: objectMethods)
                            {
                                if(m.equals(mo))
                                {
                                    flag = true;
                                    break;
                                }
                            }
                            if(!flag)
                                methodComboBox.getItems().add(m.getName());
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        methodComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                try {
                    if(newValue != null)
                        chosenMethod = chosenClass.getMethod(newValue);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        });

        addButton((event) ->
        {
            Animal a = new Animal();
            Class c = a.getClass();
            print(c.getName());
            print(c.getCanonicalName());
            print(c.getTypeName());
            print(c.getSimpleName());

            Field[] fields = c.getFields();
            print("Объект класса " + c.getSimpleName() + " имеет следующие поля: ");
            for (Field f : fields) {
                try {
                    print(f.getType().getSimpleName() + " " + f.getName() + " = " + f.get(a));

                    if (Modifier.isStatic(f.getModifiers())) {
                        f.set(null, 90);
                    }
                    print(f.get(a) + "");

                    /*print(f.get(a) + "");
                    f.set(a, 90);
                    print(f.get(a) + "");


                    print(a.age + "");
                    a.age = 90;
                    print(a.age + "");*/
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            Method[] methods = c.getMethods();
            print("Также есть следующие методы:");
            for (Method m : methods) {
                print(m.getReturnType().getSimpleName() + " " + m.getName());
                print("Кол-во параметров " + m.getParameterCount());
                print("Параметры:");
                Class[] parameterTypes = m.getParameterTypes();
                Parameter[] parameters = m.getParameters();
                for (Parameter p : parameters) {
                    print(p.getType().getSimpleName() + " " + p.getName());
                }
                int modifiers = m.getModifiers();
                if (Modifier.isStatic(modifiers)) print("STATIC!");
                if (Modifier.isPublic(modifiers)) print("PUBLIC!");

                if (m.getName().equals("produceSound") && m.getParameterCount() == 0) {
                    try {
                        m.invoke(a);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else if (m.getName().equals("produceSound") && m.getParameterCount() == 1) {
                    try {
                        m.invoke(a, "HELLO");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Method getNameMethod = c.getMethod("getName");
                print(getNameMethod.invoke(a).toString());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            Constructor[] constructors = c.getConstructors();
            print("Конструкторы:");
            for (Constructor co : constructors) {
                print(co.getName() + " с кол-вом параметров: " + co.getParameterCount());

                try {
                    Animal a2;
                    if (co.getParameterCount() == 0)

                        a2 = (Animal) (co.newInstance());

                    else if (co.getParameterCount() == 1)
                        a2 = (Animal) (co.newInstance("Название"));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            Field[] dFields = c.getDeclaredFields();
            print("ВСЕ поля:");
            for(Field f : dFields)
            {
                try {
                    f.setAccessible(true);
                    print(f.getType().getSimpleName() + " " + f.getName() + " = " + f.get(a));
                    if(f.getName().equals("name"))
                    {
                        f.set(a, "ABC");
                    }

                    print(f.getType().getSimpleName() + " " + f.getName() + " = " + f.get(a));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }});

        addButton((event) ->
        {
            try {
                Object obj = chosenClass.getConstructors()[0].newInstance();
                chosenMethod.invoke(obj);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
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
