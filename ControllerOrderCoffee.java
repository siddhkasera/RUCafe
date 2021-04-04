package RUCafeApp;

import RUCafe.Addins;
import RUCafe.Coffee;
import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderCoffee implements Initializable {


    //protected ArrayList<MenuItem> partialCoffeeOrder = new ArrayList<MenuItem>();
    protected ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
    protected Coffee coffee;
    protected Order addToOrder;
    protected int numOfAddin;


    @FXML
    protected ComboBox<String> size;

    @FXML
    protected ComboBox<Integer> quantity;
    protected ObservableList<String> sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
    protected ObservableList<Integer> qtyList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    @FXML
    protected CheckBox creamAddin;

    @FXML
    protected CheckBox milkAddin;

    @FXML
    protected CheckBox whippedCreamAddin;

    @FXML
    protected CheckBox syrupAddin;

    @FXML
    protected CheckBox caramelAddin;

    @FXML
    private TextField subtotalField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        size.setItems(sizeList);
        quantity.setItems(qtyList);

        /*
        creamAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            //subtotalField.setText();
        });

         */



    }

    //add listeners for each button and adding the price into the subtotal


    public void orderCoffee(MouseEvent mouseEvent) {
        List<Addins> checkedList = new ArrayList<>();

        List<String> checkedList2 = new ArrayList<>();

        if (creamAddin.isSelected()){
            checkedList.add(Addins.CREAM);
            checkedList2.add("Cream");
        }
        else {
            checkedList.add(null);
            checkedList2.add(null);

        }
        if (milkAddin.isSelected()) {
            checkedList.add(Addins.MILK);
            checkedList2.add("Milk");

        }
        else {
            checkedList.add(null);
            checkedList2.add(null);
        }
        if (caramelAddin.isSelected()){
            checkedList.add(Addins.CARAMEL);
            checkedList2.add("Caramel");

        }
        else {
            checkedList.add(null);
            checkedList2.add(null);
        }
        if (whippedCreamAddin.isSelected()){
            checkedList.add(Addins.WHIPPED_CREAM);
            checkedList2.add("Whipped Cream");
        }
        else {
            checkedList.add(null);
            checkedList2.add(null);
        }
        if (syrupAddin.isSelected()){
            checkedList.add(Addins.SYRUP);
            checkedList2.add("Syrup");

        }
        else {
            checkedList.add(null);
            checkedList2.add(null);
        }

        //gets the number of addIns by checking which ones weren't null in the list
        for (int i = 0; i <= 5; i++) {
            if (checkedList2.get(i) != null) {
                numOfAddin++;
            }
        }

        //create order of coffee
        Coffee orderCoffee = new Coffee(size.getValue(), checkedList2.get(0), checkedList2.get(1), checkedList2.get(2), checkedList2.get(3), checkedList2.get(4), quantity.getValue());
        Coffee numAddins = new Coffee(numOfAddin);
        orderList = addToOrder.getList(); //seeing what is inside of the list
        addToOrder.add(orderCoffee); //adding the coffee to the orderList in Order

        if (quantity.getValue() > 1) {
            for (int i = 0; i <= quantity.getValue(); i++) {
                addToOrder.add(orderCoffee);
            }
        }
    }
}