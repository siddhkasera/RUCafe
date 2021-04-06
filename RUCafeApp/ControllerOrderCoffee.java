package RUCafeApp;

import RUCafe.Addins;
import RUCafe.Coffee;
import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderCoffee implements Initializable  {


    //protected ArrayList<MenuItem> partialCoffeeOrder = new ArrayList<MenuItem>();
    protected ArrayList<MenuItem> coffeeOrderList = new ArrayList<MenuItem>();
    protected Coffee coffee;
    protected Order addToOrder;
    protected int numOfAddin;
    protected double currentTotal = 0.00;
    protected double addInCost;


    //how are we keeping track of the order number?



    @FXML
    protected ComboBox<String> size;

    protected String getSize;

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

    public ControllerMainMenu controllerMainMenu;


    Alert errorAlert = new Alert(Alert.AlertType.ERROR);

    /*
    @FXML
    private void handleCreamAddinAction() {
        if (creamAddin.isSelected()) {
            currentTotal += addInCost;
        }
        else {
            currentTotal -= addInCost;
        }
    }


     */

    public void setControllerMainMenu(ControllerMainMenu controller){
        controllerMainMenu = controller;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        size.setItems(sizeList);
        quantity.setItems(qtyList);
        DecimalFormat df = new DecimalFormat("0.00"); //look at format


        //add listeners for each button and adding the price into the subtotal

        //listener for size
        /*if (size.getSelectionModel().getSelectedItem() == sizeList.get(0)) { //short
            subtotalField.clear();
            currentTotal += 1.99;
            subtotalField.setText(df.format(currentTotal));
        }
        else if (size.getSelectionModel().getSelectedItem() == sizeList.get(1)) { //tall
            subtotalField.clear();
            currentTotal += 2.49;
            subtotalField.setText(df.format(currentTotal));
        }
        else if (size.getSelectionModel().getSelectedItem() == sizeList.get(2)) { //venti
            subtotalField.clear();
            currentTotal += 2.99;
            subtotalField.setText(df.format(currentTotal));
        }
        else if (size.getSelectionModel().getSelectedItem() == sizeList.get(3)) { //grande
            subtotalField.clear();
            currentTotal += 3.49;
            subtotalField.setText(df.format(currentTotal));
        }

         */

        //listeners for Addins


        //cream
        creamAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {

            // if (creamAddin.isSelected()) {
            currentTotal += addInCost;
            //  }
            // else {
            //    currentTotal -= addInCost;
            //   }
            subtotalField.setText(Double.toString(currentTotal));
        });

        //milk
        milkAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            }
            else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });

        //caramel
        caramelAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            }
            else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });

        //syrup
        syrupAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            }
            else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });

        //whipped cream
        whippedCreamAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            }
            else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });


    }

    public void orderCoffee(MouseEvent mouseEvent) {

        //try {
        ArrayList <String> addIns = new ArrayList<String>();
        Coffee coffeeOrder = new Coffee(size.getSelectionModel().getSelectedItem(), quantity.getValue(), addIns);

        System.out.println(size.getSelectionModel().getSelectedItem());
        System.out.println(quantity.getValue());

        if (creamAddin.isSelected()) {
            coffeeOrder.add("Cream");
            //addIns.add("Cream");

        }
        if (milkAddin.isSelected()) {
            coffeeOrder.add("Milk");
            //addIns.add("Milk");

        }
        if (caramelAddin.isSelected()) {
            coffeeOrder.add("Caramel");
            //addIns.add("Caramel");
        }
        if (whippedCreamAddin.isSelected()) {
            coffeeOrder.add("Whipped Cream");
            //addIns.add("Whipped Cream");

        }
        if (syrupAddin.isSelected()) {
            coffeeOrder.add("Syrup");
            //addIns.add("Syrup");

        }

        //System.out.println(coffeeOrder.getList());

        coffeeOrder.setNumAddOn(numOfAddin);
        ArrayList<MenuItem> coffeeOrdered = new ArrayList<MenuItem>();
        coffeeOrdered.add(coffeeOrder);
        System.out.println("The coffee order is:"+ coffeeOrder.toString());
        Order order = new Order(coffeeOrdered);
        controllerMainMenu.addMainOrder(order);
        //order.add(coffeeOrder);
        System.out.println(order.getList());

        //coffeeOrderList.add(coffeeOrder);
        //order.setList(coffeeOrderList);

        //coffeeOrderList = order.getList();

        //order.setList(coffeeOrderList);

        //addToOrder = new Order(coffeeOrder);
        // addToOrder.add(coffeeOrder); //adding the coffee to the orderList in Order

        //orderCoffee.setNumber(addToOrder.getIncrement());

        //System.out.println(addToOrder.getList().toString());

        if (quantity.getValue() > 1) {
            for (int i = 0; i <= quantity.getValue(); i++) {
                order.add(coffeeOrder);
            }
        }
        //}
        /*
        catch (NullPointerException e) {
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Please check your order. Make sure everything is complete.");
            System.out.println(e.getMessage());
            errorAlert.show();
        }

         */
    }

    public void handleCreamAddinAction(ActionEvent actionEvent) {
    }
}