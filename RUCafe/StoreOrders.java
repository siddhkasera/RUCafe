package RUCafe;
import java.util.ArrayList;
public class StoreOrders implements Customizable{


    ArrayList<Order> listOfOrders;

    public StoreOrders(){
    listOfOrders = new ArrayList<Order>();

    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            listOfOrders.add((Order)obj);
            return true;
        }
        return false;
    }

    public ArrayList<Order> getListOfOrders(){
        return this.listOfOrders;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            listOfOrders.remove((Order)obj);
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return this.listOfOrders.toString();
    }
}
