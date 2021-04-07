package RUCafeApp;

import RUCafe.StoreOrders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import RUCafe.Order;
import java.util.ArrayList;

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
    protected ComboBox<Integer> orderNumber;


    @FXML
    private ListView<String> allOrders = new ListView<String>();
    //Order newOrder = new Order();
    @FXML
    protected TextField totalAmt;

    protected ObservableList<Integer> orderNumberList = FXCollections.observableArrayList();
    private ObservableList<String> selectedOrder = FXCollections.observableArrayList();

    protected ControllerMainMenu mainController;

    public void setText(){

    }

    public void setMainController(ControllerMainMenu controller) { //gets pointer to maincontroller in here
        mainController = controller;
        //getList();
        //System.out.println("Exiting the getlist");
        for(int i =0; i< mainController.getStoreOrder().getListOfOrders().size(); i++){
            orderNumberList.add(mainController.getStoreOrder().getListOfOrders().get(i).getOrderCount());
            System.out.println(orderNumberList);
        }

    }
    public void showOrder(ActionEvent showOrder) {

        for(int i =0; i< mainController.getStoreOrder().getListOfOrders().size(); i++){
            if(orderNumber.getValue().equals(mainController.getStoreOrder().getListOfOrders().get(i).getOrderCount())){
                selectedOrder.add(mainController.getStoreOrder().getListOfOrders().get(i).toString());
                System.out.println("inside store controller"+ selectedOrder);
                allOrders.setItems(selectedOrder);
            }
            //System.out.println(orderNumberList);
        }


    }
        @Override
    public void initialize(URL location, ResourceBundle resources){
        orderNumber.setItems(orderNumberList);



    }

    public void cancelOrder(MouseEvent mouseEvent) {


    }

    public void exportOrders(MouseEvent mouseEvent) {

    }
}