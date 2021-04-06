package RUCafeApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import RUCafe.Order;
import RUCafe.MenuItem;
import java.util.ArrayList;
import javax.imageio.IIOParam;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerMainMenu {

    private Order order;

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();

    public ControllerMainMenu(){
        this.order = new Order(new ArrayList<>());
    }

    public void addMainOrder(Order menuItems){
        for(MenuItem item: menuItems.getItem()){
            System.out.println("The item in add mainorder method is "+ item);
            order.add(item);
            System.out.println(order);
        }
    }

    public void customerOrderPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("currentOrder.fxml"));
            stage.setTitle("Your Order");
            stage.setScene(new Scene(loader.load(), 650, 420));
            stage.show();
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Your order page cannot load. Try again.");
            System.out.println(e.getLocalizedMessage());
            errorAlert.show();
        }
    }

    public void storeOrdersPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("storeOrders.fxml"));
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(loader.load(), 650, 420));
            stage.show();
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            System.out.println(e.getLocalizedMessage());
            errorAlert.setContentText("Store orders page cannot load. Try again.");
            errorAlert.show();
        }
    }

    public void orderCoffeePage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderCoffee.fxml"));
            stage.setTitle("Order Coffee");
            stage.setScene(new Scene(loader.load(), 650, 420));
            stage.show();
            ControllerOrderCoffee coffeeOrderController = loader.getController();
            coffeeOrderController.setControllerMainMenu(this);
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            System.out.println(e.getLocalizedMessage());
            errorAlert.setContentText("Order Coffees page cannot load. Try again.");
            errorAlert.show();
        }
    }

    public void orderDonutPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderDonut.fxml"));
            stage.setTitle("Order Donut");
            stage.setScene(new Scene(loader.load(),650, 420));
            stage.show();

            ControllerOrderDonut donutController = loader.getController();
            donutController.setMainController(this);



        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Order Donuts page cannot load. Try again.");
            errorAlert.show();
        }

    }







}