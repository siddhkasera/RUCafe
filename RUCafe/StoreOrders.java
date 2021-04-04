package RUCafe;
import java.util.ArrayList;
public class StoreOrders implements Customizable{

   // private Order[] orderList; //order list..not sure if it is suppose to be a order object.

    ArrayList<Order> listOfOrders = new ArrayList<Order>();

    //Store  --> 10001, 10002, 10004
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            listOfOrders.add((Order)obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            listOfOrders.remove((Order)obj);
            return true;
        }
        return false;
    }
}