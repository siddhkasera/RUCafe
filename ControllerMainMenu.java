package RUCafeApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * This class processes the GUI from the payroll_processing_gui.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerMainMenu {

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();

    public void customerOrderPage(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("currentOrder.fxml"));
            stage.setTitle("Your Order");
            stage.setScene(new Scene(root, 650, 420));
            stage.show();
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Your order page cannot load. Try again.");
            errorAlert.show();
        }
    }

    public void storeOrdersPage(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("storeOrders.fxml"));
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root, 650, 420));
            stage.show();
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Store orders page cannot load. Try again.");
            errorAlert.show();
        }
    }

    public void orderCoffeePage(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("orderCoffee.fxml"));
            stage.setTitle("Order Coffee");
            stage.setScene(new Scene(root, 650, 420));
            stage.show();
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Order Coffees page cannot load. Try again.");
            errorAlert.show();
        }
    }

    public void orderDonutPage(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("orderDonut.fxml"));
            stage.setTitle("Order Donut");
            stage.setScene(new Scene(root, 650, 420));
            stage.show();
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Order Donuts page cannot load. Try again.");
            errorAlert.show();
        }
    }


}