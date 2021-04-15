package RUCafeApp;

import RUCafe.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    ArrayList<MenuItem> newList = new ArrayList<MenuItem>(); //remove this later...added only to avoid momentary error

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
            orderNumberList.add(i+1);
            newList.add(mainController.getStoreOrder().getListOfOrders().get(i).getItems().get(i));
        }

    }

    /**
     * shows the order on combo box
     * @param showOrder that calls the function.
     */
    public void showOrder(ActionEvent showOrder) {
        DecimalFormat df = new DecimalFormat("0.00"); //look at format
        for(int i = 0; i < mainController.getStoreOrder().getListOfOrders().size(); i++){
            if(orderNumber.getValue().equals(mainController.getStoreOrder().getListOfOrders().get(i).getOrderCount())){
                selectedOrder.add(mainController.getStoreOrder().getListOfOrders().get(i).toString());
                allOrders.setItems(selectedOrder);
                totalAmt.setText(df.format(mainController.getStoreOrder().getListOfOrders().get(i).getTotalPrice()));
            }
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

    public void cancelOrder(MouseEvent mouseEvent) {

        for (int i = 0; i< newList.size();i++) {
        if(newList.get(i).toString().equals(allOrders.getSelectionModel().getSelectedItem())) {
            mainController.removeItemOrder(newList.get(i));
        }
    }
        selectedOrder.remove(allOrders.getSelectionModel().getSelectedItem());

        allOrders.setItems(selectedOrder);
}


    public void exportOrders(MouseEvent mouseEvent) {

    }


}