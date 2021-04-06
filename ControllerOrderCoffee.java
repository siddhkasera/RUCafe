package RUCafeApp;

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
import java.util.ResourceBundle;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderCoffee implements Initializable {


    protected ArrayList<MenuItem> coffeeOrderList = new ArrayList<MenuItem>();
    protected ArrayList<String> addIns = new ArrayList<String>();

    protected Coffee coffee;
    protected Coffee coffeeOrder;
    protected int numOfAddin;
    protected double currentTotal = 0.00;
    private final double shortPrice = 1.99;
    private final double tallPrice = 2.49;
    private final double grandePrice = 2.99;
    private final double ventiPrice = 3.49;
    private final double addInCost = 0.20;

    DecimalFormat df = new DecimalFormat("0.00"); //look at format


    //how are we keeping track of the order number?


    @FXML
    protected ComboBox<String> size;


    @FXML
    protected ComboBox<Integer> quantity;

    protected ObservableList<String> sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");

    protected ObservableList<Integer> qtyList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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


    public void setMainMenu(ControllerMainMenu controller) {
        controllerMainMenu = controller;
    }


    public void sizeAction(ActionEvent actionEvent) {

        if (size.getValue().equals("Short")) {
            currentTotal = shortPrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (size.getValue().equals("Tall")) {
            //System.out.println("Inside tall");
            currentTotal = tallPrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (size.getValue().equals("Grande")) {
            currentTotal = grandePrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (size.getValue().equals("Venti")) {
            currentTotal = ventiPrice;
            subtotalField.setText(df.format(currentTotal));

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        size.setItems(sizeList);
        quantity.setItems(qtyList);

        creamAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            currentTotal += addInCost;
            System.out.println("Current total in cream" + currentTotal);
            subtotalField.setText(df.format(currentTotal));

        });

        //milk
        milkAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream
            if (new_val) {
                currentTotal += addInCost;
            } else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });

        //caramel
        caramelAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            } else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });

        //syrup
        syrupAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            } else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });

        //whipped cream
        whippedCreamAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> { //cream

            if (new_val) {
                currentTotal += addInCost;
            } else {
                currentTotal -= addInCost;
            }
            subtotalField.setText(df.format(currentTotal));
        });


    }

    public void orderCoffee(MouseEvent mouseEvent) {

        try {
            int numaddOns = 0;
            coffeeOrder = new Coffee(size.getSelectionModel().getSelectedItem(), quantity.getValue(), addIns, numaddOns);

            System.out.println(size.getSelectionModel().getSelectedItem());
            System.out.println(quantity.getValue());

            if (creamAddin.isSelected()) {
                coffeeOrder.add("Cream");
                numaddOns = numaddOns + 1;
            }
            if (milkAddin.isSelected()) {
                coffeeOrder.add("Milk");
                numaddOns = numaddOns + 1;
            }
            if (caramelAddin.isSelected()) {
                coffeeOrder.add("Caramel");
                numaddOns = numaddOns + 1;
            }
            if (whippedCreamAddin.isSelected()) {
                coffeeOrder.add("Whipped Cream");
                numaddOns = numaddOns + 1;
            }
            if (syrupAddin.isSelected()) {
                coffeeOrder.add("Syrup");
                numaddOns = numaddOns + 1;
            }


            coffeeOrder.setNumAddOn(numaddOns);
            coffeeOrder.itemPrice();
            ArrayList<MenuItem> coffeeOrdered = new ArrayList<>();
            coffeeOrdered.add(coffeeOrder);
            Order order = new Order(coffeeOrdered);
            controllerMainMenu.addMainOrder(order);

        } catch (NullPointerException e) {
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Please check your order. Make sure everything is complete.");
            System.out.println(e.getMessage());
            errorAlert.show();
        }


    }


}