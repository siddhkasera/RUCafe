package RUCafeApp;

import RUCafe.Addins;
import RUCafe.Coffee;
import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderCoffee implements Initializable {


    protected ArrayList<MenuItem> coffeeList;
    protected Order orderList;
    private ControllerMainMenu controllerMainMenu;
    public void setMainController(ControllerMainMenu mainMenuController) {
        controllerMainMenu = mainMenuController;
    }
    @FXML
    protected ComboBox<String> size;

    @FXML
    protected ComboBox<Integer> quantity;

    protected ObservableList<String> sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");

    protected ObservableList<Integer> qtyList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    @FXML
    protected CheckBox creamAddin;

    @FXML
    protected Checkbox milkAddin;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        size.setItems(sizeList);
        quantity.setItems(qtyList);
    }


    public void orderCoffee(MouseEvent mouseEvent) {
        List<Addins> checkedList = new ArrayList<>();
        if (creamAddin.isSelected()){
            checkedList.add(Addins.CREAM);
        }
        //else if()

        Coffee orderCoffee = new Coffee(size.getValue(),null);
        //coffeeList = orderList.getList();
        //coffeeList.add(orderCoffee);
        orderList.add(orderCoffee);
        coffeeList.add(orderCoffee);

    }

    /*public ArrayList<MenuItem> getList() {
        return coffeeList;
    }
*/
}