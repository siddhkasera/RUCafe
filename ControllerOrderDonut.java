package RUCafeApp;

import RUCafe.Donut;
import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class processes the GUI from orderDonut.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderDonut implements Initializable {

    protected static ControllerMainMenu mainController;
    protected double currentTotal;
    private final double yeastPrice = 1.39;
    private final double cakePrice = 1.59;
    private final double donutHolePrice = 0.33;
    private ArrayList<Integer> quantityList = new ArrayList<Integer>();



    DecimalFormat df = new DecimalFormat("0.00"); //look at format

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private ComboBox<String> donutType;

    protected ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast", "Cake", "Donut Hole");

    //when user clicks on type --> show the price in subtotal
    ObservableList<String> flavors = FXCollections.observableArrayList(
            "Chocolate", "Vanilla", "Strawberry", "Sugar Glazed");

    @FXML
    protected ListView<String> flavorsListView = new ListView<String>(flavors);

    ObservableList<String> selectedFlavor = FXCollections.observableArrayList();

    protected ObservableList<Integer> qtyList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @FXML
    protected ListView<String> selectedFlavorListView = new ListView<>(selectedFlavor);

    @FXML
    private TextField subtotalField;

    @FXML
    private ComboBox<Integer> quantity;

    protected ControllerMainMenu controllerMainMenu;

    ArrayList<MenuItem> donutOrdered = new ArrayList<>();
    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);


    /**
     * reference for main controller
     * @param controller reference
     */

    public void setDonutMainMenu(ControllerMainMenu controller) {
        controllerMainMenu = controller;
    }


    /**
     * get the information about the type of donut
     * @param actionEvent that calls the function.
     */
    public void typeAction(ActionEvent actionEvent) {

        if (donutType.getValue().equals("Yeast")) {
            currentTotal = yeastPrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (donutType.getValue().equals("Cake")) {
            currentTotal = cakePrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (donutType.getValue().equals("Donut Hole")) {
            currentTotal = donutHolePrice;
            subtotalField.setText(df.format(currentTotal));

        }
    }

    /**
     * collects the quantity of the donut
     * @param actionEvent that calls the function.
     */

    public void qtyAction(ActionEvent actionEvent) {

        try {
            for (int i = 1; i <= quantity.getVisibleRowCount(); i++) {
                if (quantity.getValue().equals(i)) {
                    if (donutType.getValue().equals("Yeast")) {
                        currentTotal = yeastPrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    } else if (donutType.getValue().equals("Cake")) {
                        currentTotal = cakePrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    } else if (donutType.getValue().equals("Donut Hole")) {
                        currentTotal = donutHolePrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    }
                    subtotalField.setText(df.format(currentTotal));
                }
            }
        }
        catch (NullPointerException e) {
            errorAlert.setHeaderText("Choose a donut type");
            errorAlert.setContentText("Please choose a size for your order.");
            errorAlert.show();
        }

    }

    /**
     * Intializes List views and combo boxes
     * @param location location of .fxml file
     * @param resources accesses data.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        donutType.setItems(donutTypeList);
        quantity.setItems(qtyList);
        flavorsListView.setItems(flavors);

    }

    /**
     * handles ordering donuts
     * @param mouseEvent that calls the function.
     */
    public void orderDonut(MouseEvent mouseEvent) {

        if (!selectedFlavor.isEmpty()) {
            Order order = new Order(donutOrdered);
            //System.out.println(donutOrdered.toString());
            //System.out.println(order.toString());
            controllerMainMenu.addMainOrder(order);
        }

        else {
            infoAlert.setHeaderText("Order Unsuccessful");
            infoAlert.setContentText("Please add your selected flavor to the next list view.");
        }

    }

    /**
     * adds the flavors selected by the user.
     * @param mouseEvent that calls the function.
     */
    public void addFlavorOnList(MouseEvent mouseEvent) {
        System.out.println("In the add flavor list");
        selectedFlavor.add(flavorsListView.getSelectionModel().getSelectedItem());
        //Donut donutOrder = new Donut(donutType.getValue(), flavorsListView.getSelectionModel().getSelectedItem(), quantityList);
        quantityList.add(quantity.getValue());
        System.out.println("Quantity value is" + quantity.getValue());
        Donut donutOrder = new Donut(donutType.getValue(), flavorsListView.getSelectionModel().getSelectedItem(), quantityList);
        donutOrder.add(quantity.getValue()); //this will keep track of the quantity that each donut had in the order adds it to the list
        donutOrdered.add(donutOrder);

        donutOrder.itemPrice();
        double donutPrice = donutOrder.getDonutPrice();
        System.out.println("Donut price " + donutPrice);
        selectedFlavorListView.setItems(selectedFlavor);
    }
    /**
     * removes the flavors
     * @param mouseEvent that calls the function.
     */
    public void removeFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavor.remove(selectedFlavorListView.getSelectionModel().getSelectedItem());
        selectedFlavorListView.setItems(selectedFlavor);

    }


}