package RUCafe;

import java.util.ArrayList;

public class Order implements Customizable {
    private int orderCount;
    //private static final int CAPACITY = 4;
    //private MenuItem [] orderList;
    //list of menu items added.
    //private static int orderNumber = 10000;
    public static String orderNum;
    //MenuItem menuitem = new MenuItem();
    ArrayList<MenuItem> orderlist = new ArrayList<MenuItem>();  //list -->list should be an instance of object order.

    public Order(String orderNum){
        //orderNumber = orderNumber++;
        //orderNum = String.valueOf(orderNumber);
        this.orderNum = orderNum;


    }



    @Override
    public boolean add(Object obj) {
        if(obj instanceof Coffee || obj instanceof Donut){
                orderlist.add((MenuItem) obj);
                //orderCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Coffee || obj instanceof Donut){
            orderlist.remove((MenuItem)obj);
            //orderCount--;
            return true;
        }
        return false;
    }
}
