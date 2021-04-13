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
 * This class processes the GUI from the orderCoffee.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderCoffee implements Initializable {


    protected ArrayList<String> addIns = new ArrayList<String>();

    protected Coffee coffeeOrder;
    protected double currentTotal = 0.00;
    private final double shortPrice = 1.99;
    private final double tallPrice = 2.49;
    private final double grandePrice = 2.99;
    private final double ventiPrice = 3.49;
    private final double addInCost = 0.20;

    @FXML
    protected ComboBox<String> size;

    @FXML
    protected ComboBox<Integer> quantity;

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

    protected ObservableList<String> sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");

    protected ObservableList<Integer> qtyList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public ControllerMainMenu controllerMainMenu;

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);

    DecimalFormat df = new DecimalFormat("0.00"); //look at format

    /**
     * reference for main controller
     * @param controller main reference
     */
    public void setMainMenu(ControllerMainMenu controller) {
        controllerMainMenu = controller;
    }

    /**
     * Collects in the information about the size of coffee selected by user.
     * @param actionEvent that calls the function.
     */
    public void sizeAction(ActionEvent actionEvent) {

        if (size.getValue().equals("Short")) {
            currentTotal = shortPrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (size.getValue().equals("Tall")) {
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

    /**
     * Collects the quantity of the coffee
     * @param actionEvent that calls the function.
     */
    public void qtyAction(ActionEvent actionEvent) {

        try {
            for (int i = 1; i <= quantity.getVisibleRowCount(); i++) {
                if (quantity.getValue().equals(i)) {
                    if (size.getValue().equals("Short")) {
                        currentTotal = shortPrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    } else if (size.getValue().equals("Tall")) {
                        currentTotal = tallPrice * i + addInCost;
                        subtotalField.setText(df.format(currentTotal));

                    } else if (size.getValue().equals("Grande")) {
                        currentTotal = grandePrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    } else if (size.getValue().equals("Venti")) {
                        currentTotal = ventiPrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    }
                    subtotalField.setText(df.format(currentTotal));
                }
            }
        }
        catch (NullPointerException e) {
            errorAlert.setHeaderText("Choose a size");
            errorAlert.setContentText("Please choose a size for your order.");
            errorAlert.show();
        }

        creamAddin.setDisable(false);
        milkAddin.setDisable(false);
        syrupAddin.setDisable(false);
        caramelAddin.setDisable(false);
        whippedCreamAddin.setDisable(false);

    }

    /**
     * Intializes the combo box for the page
     * @param location of the fxml file
     * @param resources accesses data
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        size.setItems(sizeList);
        quantity.setItems(qtyList);

        creamAddin.setDisable(true);
        milkAddin.setDisable(true);
        syrupAddin.setDisable(true);
        caramelAddin.setDisable(true);
        whippedCreamAddin.setDisable(true);


        creamAddin.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            currentTotal += addInCost;
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

    /**
     * handles ordering coffee action
     * @param mouseEvent that calls the function.
     */
    public void orderCoffee(MouseEvent mouseEvent) {

        try {
            int numaddOns = 0;
            coffeeOrder = new Coffee(size.getSelectionModel().getSelectedItem(), quantity.getValue(), addIns, numaddOns);

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
            double price1 = coffeeOrder.getCoffeePrice();
            System.out.println("Price of the coffee added "+  price1);
            ArrayList<MenuItem> coffeeOrdered = new ArrayList<>();
            coffeeOrdered.add(coffeeOrder);
            Order order = new Order(coffeeOrdered);
            controllerMainMenu.addMainOrder(order);

        } catch (NullPointerException e) {
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Please check your order. Make sure everything is complete.");
            errorAlert.show();
        }

    }



}