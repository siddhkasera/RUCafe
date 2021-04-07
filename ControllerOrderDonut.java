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
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderDonut implements Initializable {

    //display the subtotal dynamically

    //add listeners for each button and adding the price into the subtotal

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

    private int selectedFlavorCounter;

    protected ControllerMainMenu controllerMainMenu;

    ArrayList<MenuItem> donutOrdered = new ArrayList<>();



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

    public void setMainController(ControllerMainMenu controller){ //gets pointer to maincontroller in here
        //when setting a donut order, needing the instance to go into main controller
        mainController = controller;
    }

    /*
    public int getNumOfSelectedFlavors(ListView<String> list) {

        for (int i = 0; selectedFlavor.size(); i++)

        return i;
    }

     */

    //set number for the donut
    public void orderDonut(MouseEvent mouseEvent) {

       // for (int i = 0; i < selectedFlavor.size(); i++) {
          //Donut donutOrder = new Donut(donutType.getValue(), selectedFlavor.get(i), quantityList);
          Order order = new Order(donutOrdered);
          System.out.println(donutOrdered.toString());
          System.out.println(order.toString());
          controllerMainMenu.addMainOrder(order);
      //  }

    }


    public void addFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavor.add(flavorsListView.getSelectionModel().getSelectedItem());

        Donut donutOrder = new Donut(donutType.getValue(), flavorsListView.getSelectionModel().getSelectedItem(), quantityList);
        donutOrdered.add(donutOrder);
        quantityList.add(quantity.getValue());
        donutOrder.add(quantity.getValue()); //this will keep track of the quantity that each donut had in the order adds it to the list

        selectedFlavorListView.setItems(selectedFlavor);

        System.out.println(quantityList);
        System.out.println();







        //donut.setQuantity(quantity.getValue());
        //selectedFlavorCounter++; //has the number of the order in selected flavor with the correct quantity

        //quantityInOrder.add(quantity.getValue());
        //System.out.println(quantityInOrder);


        //adjust the subtotal in here

    }

    public void removeFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavor.remove(selectedFlavorListView.getSelectionModel().getSelectedItem());

       // selectedFlavorListView.getCellFactory()
      //  quantityInOrder.remove(selectedFlavorCounter);

        selectedFlavorListView.setItems(selectedFlavor);

    }


}