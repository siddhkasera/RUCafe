package RUCafeApp;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import RUCafe.Order;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
//me
//click on add to order.
public class ControllerStoreOrders implements Initializable {

    @FXML
    protected ComboBox<String> orderNumber;
    //Order newOrder = new Order();
    protected ObservableList<String> orderNumberList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        orderNumber.setItems(orderNumberList);
    }

    public void cancelOrder(MouseEvent mouseEvent) {


    }

    public void exportOrders(MouseEvent mouseEvent) {

    }
}