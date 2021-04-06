package RUCafe;

import javafx.scene.control.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Order implements Customizable {
    //private final Object items;
    protected static int orderCount = 1;
    private int orderNumber;
    protected static String orderNum;
    private double totalPrice;
    private MenuItem item;
    private Coffee coffee;
    ArrayList<MenuItem> orderlist = new ArrayList<MenuItem>();  //list -->list should be an instance of object order.


    public Order(MenuItem item) {
        this.item = item;
    }

    public Order() {

    }
    /* public Order (Coffee coffee) {
        this.coffee = coffee;
    }

     */

    /*public Order(ArrayList<MenuItem> orderList){
        this.orderlist = orderList;
        this.orderNumber = orderCount;
        this.totalPrice = 0;
    }

     */

    public void setIncrement() {
        orderCount++;
    }

    public int getOrderNumber() {
        return this.orderCount;
    }

    public static int getCounter() {
        return orderCount;
    }

    public void setList(ArrayList<MenuItem> list){
        this.orderlist = new ArrayList<MenuItem>(list);
    }



    @Override
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            orderlist.add((MenuItem) obj);
            //orderCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof MenuItem) {
            orderlist.remove(obj);
            //orderCount--;
            return true;
        }
        return false;
    }

    public ArrayList<String> getList() {

        //return new ArrayList<MenuItem>(this.orderlist);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < orderlist.size(); i++) {
            list.add(orderlist.get(i).getItem());
        }

        return list;
    }

}
