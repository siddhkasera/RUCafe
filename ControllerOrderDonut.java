package RUCafeApp;

import RUCafe.Donut;
import RUCafe.MenuItem;
import RUCafe.Order;
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
public class ControllerOrderDonut implements Initializable {

    protected Order addToOrder;
    protected Donut donut;
    protected static ControllerMainMenu mainController;
    protected double currentTotal;
    private final double yeastPrice = 1.39;
    private final double cakePrice = 1.59;
    private final double donutHolePrice = 0.33;
    private ArrayList<Integer> quantityList = new ArrayList<Integer>();


    DecimalFormat df = new DecimalFormat("0.00"); //look at format

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);

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

    @FXML
    private Button addOrderButton;


    public void setDonutMainMenu(ControllerMainMenu controller) {
        controllerMainMenu = controller;
    }

    public void typeAction(ActionEvent actionEvent) {

        if (donutType.getValue().equals("Yeast")) {
            currentTotal = yeastPrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (donutType.getValue().equals("Cake")) {
            //System.out.println("Inside tall");
            currentTotal = cakePrice;
            subtotalField.setText(df.format(currentTotal));

        } else if (donutType.getValue().equals("Donut Hole")) {
            currentTotal = donutHolePrice;
            subtotalField.setText(df.format(currentTotal));

        }
    }

    public void qtyAction(ActionEvent actionEvent) {

        try {
            for (int i = 1; i <= quantity.getVisibleRowCount(); i++) {
                if (quantity.getValue().equals(i)) {
                    if (donutType.getValue().equals("Yeast")) {
                        currentTotal = yeastPrice * i;
                        subtotalField.setText(df.format(currentTotal));

                    } else if (donutType.getValue().equals("Cake")) {
                        //System.out.println("Inside tall");
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
            System.out.println(e.getMessage());
            errorAlert.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        donutType.setItems(donutTypeList);
        quantity.setItems(qtyList);
        flavorsListView.setItems(flavors);
    }

    //set number for the donut
    public void orderDonut(MouseEvent mouseEvent) {

        if (!selectedFlavor.isEmpty()) {
            Order order = new Order(donutOrdered);
            System.out.println(donutOrdered.toString());
            System.out.println(order.toString());
            controllerMainMenu.addMainOrder(order);
        }

        else {
            infoAlert.setHeaderText("Order Unsuccessful");
            infoAlert.setContentText("Please add your selected flavor to the next list view.");
        }

    }

    public void addFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavor.add(flavorsListView.getSelectionModel().getSelectedItem());
        Donut donutOrder = new Donut(donutType.getValue(), flavorsListView.getSelectionModel().getSelectedItem(), quantityList);
        donutOrdered.add(donutOrder);
        donutOrder.itemPrice();

        quantityList.add(quantity.getValue());
        donutOrder.add(quantity.getValue()); //this will keep track of the quantity that each donut had in the order adds it to the list
        selectedFlavorListView.setItems(selectedFlavor);
        System.out.println(quantityList);
        System.out.println();
    }

    public void removeFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavor.remove(selectedFlavorListView.getSelectionModel().getSelectedItem());
        donutOrdered.remove(selectedFlavorListView.getSelectionModel().getSelectedItem());
        //remove from maincontroller
        selectedFlavorListView.setItems(selectedFlavor);

    }


}