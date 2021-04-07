package RUCafeApp;

import RUCafe.Coffee;
import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TextArea;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerCurrentOrder implements Initializable{

    ArrayList<MenuItem> newList; //remove this later...added only to avoid momentary error
    Order orderList = new Order(newList);
    Coffee addInsList = new Coffee();
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    private double totalPrice;
    private double subtotal;
    private double tax;

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


    private void setText(){
         subtotal = mainController.getOrder().getTotalPrice();
        //System.out.println("The price is "+ subTotal);
        tax = subtotal * 0.06625;
        totalPrice = subtotal + tax;
        DecimalFormat df = new DecimalFormat("0.00"); //look at format
        salesTax.setText(df.format(tax));
        subTotal.setText(df.format(subtotal));
        total.setText(df.format(totalPrice));

    }

    public void setMainController(ControllerMainMenu controller){ //gets pointer to maincontroller in here
        mainController = controller;
        setText();
        for(int i =0; i< mainController.getOrder().getItem().size(); i++){
            orderList = mainController.getOrder();
            System.out.println("Only the order list in current order" + orderList);
                listOfItem.add(mainController.getOrder().getItem().get(i).toString());
                System.out.println(listOfItem);
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            orderListView.setItems(listOfItem);

    }

    public void removeItem(MouseEvent mouseEvent) {
       // ObservableList<String> removeOrder = orderListView.getSelectionModel().getSelectedItems();
        listOfItem.remove(orderListView.getSelectionModel().getSelectedItem());
        //orderList.remove(orderListView.getSelectionModel().getSelectedItem());
        //System.out.println(orderListView.getSelectionModel().getSelectedItem().getClass());
        System.out.println("After removing from orderlist"+ orderList);
       // mainController.removeItem(orderListView.getSelectionModel().getSelectedItem());
        //orderList.remove(removeOrder);
        //listOfItem.remove(removeOrder);
        orderListView.setItems(listOfItem);
        salesTax.clear();
        total.clear();
        subTotal.clear();
        totalPrice =0;
        subtotal = 0;
        tax=0;
    }

    public void placeOrder(MouseEvent mouseEvent) {
        //System.out.println("When place order is triggered");
        mainController.placeOrder();
        salesTax.clear();
        total.clear();
        subTotal.clear();
        totalPrice =0;
        subtotal = 0;
        tax=0;
    }


}