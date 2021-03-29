package RUCafe;

import java.util.ArrayList;

public class Order implements Customizable {
    private int orderCount;
    private static final int CAPACITY = 4;
    //private MenuItem [] orderList;
    //list of menu items added.
    private static int orderNumber = 10000;
    public static String orderNum = "10000";
    //MenuItem menuitem = new MenuItem();
    ArrayList<String> orderlist = new ArrayList<String>();


    @Override
    public boolean add(Object obj) {
        if(obj instanceof Coffee || obj instanceof Donut){
                orderlist.add((String) obj);
                orderCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Coffee || obj instanceof Donut){
            orderlist.remove((String) obj);
            orderCount--;
            return true;
        }
        return false;
    }
}
