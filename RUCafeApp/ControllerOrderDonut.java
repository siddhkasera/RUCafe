package RUCafeApp;

import RUCafe.MenuItem;
import RUCafe.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerOrderDonut implements Initializable {

    //display the subtotal dynamically

    //add listeners for each button and adding the price into the subtotal

    protected Order addToOrder;
    protected static ControllerMainMenu mainController;

    @FXML
    protected ComboBox<String> donutType;

    protected ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast", "Cake", "Donut Hole");

    //when user clicks on type --> show the price in subtotal


    ObservableList<String> flavors = FXCollections.observableArrayList(
            "Chocolate", "Vanilla", "Strawberry", "Sugar Glazed");

    @FXML
    protected ListView<String> flavorsListView = new ListView<String>(flavors);

    ObservableList<String> selectedFlavor = FXCollections.observableArrayList(flavorsListView.getSelectionModel().getSelectedItems());

    @FXML
    protected ListView<String> selectedFlavorListView = new ListView<>(selectedFlavor);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        donutType.setItems(donutTypeList);
        flavorsListView.setItems(flavors);

        //donutType.valueProperty().addListener();

    }


    public void setMainController(ControllerMainMenu controller){ //gets pointer to maincontroller in here

        //when setting a donut order, needing the instance to go into main controller

        mainController = controller;


    }

    //set number for the donut
    public void orderDonut(MouseEvent mouseEvent) {



    }

    public void addFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavorListView.setItems(selectedFlavor);
    }

    public void removeFlavorOnList(MouseEvent mouseEvent) {
        selectedFlavorListView.getItems().remove(selectedFlavorListView.getSelectionModel().getSelectedItems());
    }
}