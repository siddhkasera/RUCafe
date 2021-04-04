package RUCafeApp;

import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerCurrentOrder implements Initializable{

    Order orderList;
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);

    protected ControllerMainMenu mainController;


    @FXML
    protected ListView<String> orderListView = new ListView<String>();



    //setMainController
    //pass items from the order
    //for list that goes through each item that goes through order array list and adds to observable list
    //after adding to observable list do listview.setitems()

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            ObservableList<String> items = FXCollections.observableArrayList(orderList.getList().toString());
            for (int i = 0; i < orderList.getList().size(); i++) {
                orderListView.setItems(items);
            }
        }

          catch (NullPointerException e) {
              errorAlert.setHeaderText("No items in your order");
              errorAlert.setContentText("Please add items to your order.");
              errorAlert.show();
            }

    }

    public void removeItem(MouseEvent mouseEvent) {

        //remove from Order
        orderList.remove(orderListView.getSelectionModel().getSelectedItems());

    }

    public void placeOrder(MouseEvent mouseEvent) {
    }

    public void setMainController(ControllerMainMenu controller){ //gets pointer to maincontroller in here
        mainController = controller;
        // mainController.getOrder doesn't work
        //set observable list to the correct values

    }

    //initialize method
        //assign list view items in setMainController
        //then call ListView in initialize

}