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
        double subtotal = mainController.getOrder().getTotalPrice();
        //System.out.println("The price is "+ subTotal);
        double tax = subtotal * 0.06625;
        double totalPrice = subtotal + tax;
        DecimalFormat decimalFormat = new DecimalFormat("###, ###, ##0.00");
        salesTax.setText(decimalFormat.format(tax));
        subTotal.setText(decimalFormat.format(subtotal));
        total.setText(decimalFormat.format(totalPrice));

    }
    //setMainController
    //pass items from the order
    //for list that goes through each item that goes through order array list and adds to observable list
    //after adding to observable list do listview.setitems()
    public void setMainController(ControllerMainMenu controller){ //gets pointer to maincontroller in here
        mainController = controller;
        setText();
        for(int i =0; i< mainController.getOrder().getItem().size(); i++){
                listOfItem.add(mainController.getOrder().getItem().get(i).toString());
                System.out.println(listOfItem);
        }


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // for(int i =0; i< listOfItem.size(); i++) {
            orderListView.setItems(listOfItem);

        //System.out.println("Orderlistview is"+ orderListView);
    }
    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            System.out.println(orderList.getList());
            System.out.println(addInsList.getList());

            ObservableList<String> menuItems = FXCollections.observableArrayList(orderList.getList());
            ObservableList<String> addInItems = FXCollections.observableArrayList(addInsList.getList());

            for (int i = 0; i < orderList.getList().size(); i++) {
                orderListView.setItems(menuItems);
                orderListView.setItems(addInItems);
            }
        }

        catch (NullPointerException e) {
            errorAlert.setHeaderText("No items in your order");
            errorAlert.setContentText("Please add items to your order.");
            errorAlert.show();
        }

    }
    */
    public void removeItem(MouseEvent mouseEvent) {
        orderList.remove(orderListView.getSelectionModel().getSelectedItems());
    }

    public void placeOrder(MouseEvent mouseEvent) {
        mainController.placeOrder();
    }



    //initialize method
    //assign list view items in setMainController
    //then call ListView in initialize

}