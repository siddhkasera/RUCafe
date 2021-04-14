package RUCafeApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import RUCafe.Order;
import RUCafe.MenuItem;
import java.util.ArrayList;
import RUCafe.Coffee;
import RUCafe.Donut;
import RUCafe.StoreOrders;

/**
 * This class processes the GUI from the mainMenu.fxml in order to
 * manage different operations on GUI
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/
public class ControllerMainMenu {

    private Order order;
    private StoreOrders allOrders;
    protected double price= 0;
    //protected int orderNumber = 0;
    protected int NOT_FOUND = 0;


    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    Stage stage = new Stage();

    /**
     * Constructor for the class to assign order and store orders.
     */
    public ControllerMainMenu(){
        this.allOrders = new StoreOrders();
        this.order = new Order(new ArrayList<>());
    }

    /**
     * adds the menuitems to the main order object
     * @param menuItems to be added
     */
    public void addMainOrder(Order menuItems){
        for(MenuItem item: menuItems.getItems()){
            order.add(item);
            if(item instanceof Coffee){
                price = price +  ((Coffee) item).getCoffeePrice();
            }
            if(item instanceof Donut){
                System.out.println("Adding donut to the order");
                price = price + ((Donut) item).getDonutPrice();
                System.out.println("Price of the donut added " + price);
            }
            order.setTotalPrice(price);
        }
        System.out.println("Order in the add main order " + order);

    }

    /**
     * removes items from the main object
     * @param menuItem to be removed
     */

    public void removeItemOrder(MenuItem menuItem){
        int index = findIndex(menuItem);

        for (int i = index; i < order.getItems().size(); i++) {
            order.remove(menuItem);

            if(menuItem instanceof Coffee){
                price = price -  ((Coffee) menuItem).getCoffeePrice();
            }
            if(menuItem instanceof Donut){
                price = price - ((Donut) menuItem).getDonutPrice();
            }
            order.setTotalPrice(price);
        }
        System.out.println("Order after removing " + order);
    }

    public int findIndex(MenuItem menuItem) {

        for(int i = 0; i < order.getItems().size(); i++) {
            if (order.getItems().get(i).toString().equals(menuItem.toString())) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * returns the main order
     * @return order object
     */
    public Order getOrder(){
        return order;
    }

    /**
     * returns the main store order
     * @return store order object
     */
    public StoreOrders getStoreOrder(){
        return allOrders;
    }

    /**
     * place order helper method
     */
    public void placeOrder(){
        order.setIncrement();
        allOrders.add(order);
        //removeOrder(order);
        //System.out.println("After removing order" + order);
        this.order = new Order(new ArrayList<>());
        //order.setTotalPrice(0);
        price = 0;
        //System.out.println("After removing order" + order);


    }

    /**
     * loads the customer order page
     * @param mouseEvent action that invokes the function.
     */
    public void customerOrderPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("currentOrder.fxml"));
            stage.setTitle("Your Order");
            stage.setScene(new Scene(loader.load(), 650, 420));
            stage.show();
            ControllerCurrentOrder currentOrder =loader.getController();
            currentOrder.setMainController(this);


        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Your order page cannot load. Try again.");
            errorAlert.show();
        }
    }
    /**
     * loads the store  order page
     * @param mouseEvent action that invokes the function.
     */
    public void storeOrdersPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("storeOrders.fxml"));
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(loader.load(), 650, 420));
            stage.show();
            ControllerStoreOrders storeOrderController = loader.getController();
            storeOrderController.setMainController(this);
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Store orders page cannot load. Try again.");
            errorAlert.show();
        }
    }
    /**
     * loads the coffee order page
     * @param mouseEvent action that invokes the function.
     */

    public void orderCoffeePage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderCoffee.fxml"));
            stage.setTitle("Order Coffee");
            stage.setScene(new Scene(loader.load(), 650, 420));
            stage.show();
            ControllerOrderCoffee coffeeOrderController = loader.getController();
            coffeeOrderController.setMainMenu(this);
        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Order Coffees page cannot load. Try again.");
            errorAlert.show();
        }
    }
    /**
     * loads the donut order page
     * @param mouseEvent action that invokes the function.
     */
    public void orderDonutPage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderDonut.fxml"));
            stage.setTitle("Order Donut");
            stage.setScene(new Scene(loader.load(),650, 420));
            stage.show();
            ControllerOrderDonut donutController = loader.getController();
            donutController.setDonutMainMenu(this);

        }
        catch (Exception e){
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Order Donuts page cannot load. Try again.");
            errorAlert.show();
        }

    }


}