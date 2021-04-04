package RUCafeApp;

import javafx.collections.FXCollections;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import RUCafe.Order;
import java.util.ArrayList;
import RUCafe.MenuItem;
import RUCafe.Coffee;
import RUCafeApp.ControllerOrderCoffee;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
//me
public class ControllerCurrentOrder {

    @FXML
    protected ListView<String> currentOrderListView = new ListView<String>();

    ObservableList <String>  orderItems = FXCollections.observableArrayList();

    protected Order orderList;
    //protected  ArrayList<MenuItem> newArrayList = new ArrayList<MenuItem>(ControllerOrderCoffee.getList());
    //newArrayList =  ControllerOrderCoffee.getList();

    public void removeItem(MouseEvent mouseEvent) {

    }

    public void placeOrder(MouseEvent mouseEvent) {
    }
}