package RUCafeApp;

import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.ArrayList;

/**
 * This class processes the GUI from the meinMenu.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerCurrentOrder implements Initializable{

    ArrayList<MenuItem> newList = new ArrayList<MenuItem>(); //remove this later...added only to avoid momentary error
    Order orderList = new Order(newList);
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    private double totalPrice;
    private double subtotal;
    private double tax;
    private final double taxRate = 0.06625;

    protected ControllerMainMenu mainController;
    private ObservableList<String> listOfItem = FXCollections.observableArrayList();

    @FXML
    private TextField subTotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField total;

    @FXML
    private ListView<String> orderListView = new ListView<String>();

    /**
     * sets text to the text fields on the GUI
     */
    private void setText(){
        subtotal = mainController.getOrder().getTotalPrice();
        tax = subtotal * taxRate;
        totalPrice = subtotal + tax;
        DecimalFormat df = new DecimalFormat("0.00"); //look at format
        salesTax.setText(df.format(tax));
        subTotal.setText(df.format(subtotal));
        total.setText(df.format(totalPrice));

    }

    /**
     * sets a reference to main controller
     * @param controller reference
     */
    public void setMainController(ControllerMainMenu controller){ //gets pointer to maincontroller in here
        mainController = controller;
        setText();
        for(int i =0; i< mainController.getOrder().getItems().size(); i++){
            orderList = mainController.getOrder();
                listOfItem.add(mainController.getOrder().getItems().get(i).toString());
                newList.add(mainController.getOrder().getItems().get(i));
        }

    }

    /**
     * intializes a list view on GUI
     * @param location location of fxml file.
     * @param resources accesses data
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            orderListView.setItems(listOfItem);

    }

    /**
     * removes item from lists
     * @param mouseEvent action on which method is called.
     */
    public void removeItem(MouseEvent mouseEvent) {
        listOfItem.remove(orderListView.getSelectionModel().getSelectedItem()); //removing the observable list
        for(int i =0; i< newList.size();i++) {
            if(newList.get(i).toString().equals(orderListView.getSelectionModel().getSelectedItem())) {
                mainController.removeItemOrder(newList.get(i));
            }
        }
        orderListView.setItems(listOfItem);
        salesTax.clear();
        total.clear();
        subTotal.clear();
        totalPrice =0;
        subtotal = 0;
        tax=0;
    }

    /**
     * places order the user selected
     * @param mouseEvent action that triggers the function.
     */
    public void placeOrder(MouseEvent mouseEvent) {
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setTitle("Confirm to place the order");
        a.setAlertType(Alert.AlertType.CONFIRMATION);
        a.setContentText("Do you want to place the order");
        a.show();

        mainController.placeOrder();
        salesTax.clear();
        total.clear();
        subTotal.clear();
        totalPrice =0;
        subtotal = 0;
        tax=0;
    }


}