package RUCafeApp;

import RUCafe.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import RUCafe.Order;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * This class processes the GUI from the storeOrders.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/

public class ControllerStoreOrders implements Initializable {

    @FXML
    protected ComboBox<Integer> orderNumber;

    ArrayList<Order> newOrderList = new ArrayList<Order>(); //remove this later...added only to avoid momentary error

    @FXML
    private ListView<String> allOrders = new ListView<String>();
    //Order newOrder = new Order();
    @FXML
    protected TextField totalAmt;


    private double totalPrice;
    private double subtotal;
    private double tax;

    protected ObservableList<Integer> orderNumberList = FXCollections.observableArrayList();
    private ObservableList<String> selectedOrder = FXCollections.observableArrayList();
    private ObservableList<String> emptyList = FXCollections.observableArrayList();

    protected ControllerMainMenu mainController;

    public void setText(){
        subtotal = mainController.getOrder().getTotalPrice();
        tax = subtotal * 0.06625;
        totalPrice = subtotal + tax;
        DecimalFormat df = new DecimalFormat("0.00"); //look at format
        totalAmt.setText(df.format(totalPrice));
    }


    /**
     * gets the reference to main
     * @param controller reference
     */
    public void setMainController(ControllerMainMenu controller) { //gets pointer to maincontroller in here
        mainController = controller;

        for(int i = 0; i< mainController.getStoreOrder().getListOfOrders().size(); i++){
            orderNumberList.add(mainController.getStoreOrder().getListOfOrders().get(i).getOrderNumber());
            newOrderList.add(mainController.getStoreOrder().getListOfOrders().get(i));
        }


    }

    public int orderDetails(int orderNumber){

        for(int i = 0; i< newOrderList.size(); i++){
            if(newOrderList.get(i).getOrderNumber()== orderNumber){
                selectedOrder.add(newOrderList.get(i).toString());
                return i;
            }
        }
        return 0;
    }
    /**
     * shows the order on combo box
     * @param showOrder that calls the function.
     */
    public void showOrder(ActionEvent showOrder) {
        System.out.println("Order Number List in show order " + orderNumberList);
        int selectedNumber = 0;
        DecimalFormat df = new DecimalFormat("0.00"); //look at format
        //if(orderNumberList.size() > 0) {
        boolean isTrue = orderNumber.getValue() == null;
        if(! isTrue){
            selectedNumber = orderNumber.getValue();
            selectedOrder = FXCollections.observableArrayList();
            int index = orderDetails(selectedNumber);
           // System.out.println("")
            System.out.println("selected order " + selectedOrder.toString());
            //System.out.println("\n");
            allOrders.setItems(selectedOrder);

            totalAmt.setText(df.format(newOrderList.get(index).getTotalPrice()));
        }

    }

    /**
     * intializes the combobox.
     * @param location .fxml location
     * @param resources accesses data
     */
    @Override
    public void initialize(URL location, ResourceBundle resources){
        orderNumber.setItems(orderNumberList);
    }

    public void removeOrderNumber(int orderNumber){
        for(int i =0; i< orderNumberList.size(); i++)
        {
            if(orderNumberList.get(i) == orderNumber){
                orderNumberList.remove(i);
            }
        }
    }
    public void cancelOrder(MouseEvent mouseEvent) {

        for (int i = 0; i< newOrderList.size();i++) {
            if(newOrderList.get(i).toString().equals(allOrders.getSelectionModel().getSelectedItem())) {
                removeOrderNumber(newOrderList.get(i).getOrderNumber());
                orderNumber.setItems(orderNumberList);
                mainController.removeOrder(newOrderList.get(i));
                System.out.println("Order removed is " + newOrderList.get(i).toString());
            }
        }
        selectedOrder.remove(allOrders.getSelectionModel().getSelectedItem());
        totalAmt.clear();
    }

    public void exportOrders(MouseEvent mouseEvent) {

    }


}