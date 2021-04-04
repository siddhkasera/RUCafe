package RUCafe;

import java.util.ArrayList;

public class Order implements Customizable {
    //private final Object items;
    public static int orderCount = 1;
    private int orderNumber;
    public static String orderNum;
    private double totalPrice;
    ArrayList<MenuItem> orderlist = new ArrayList<MenuItem>();  //list -->list should be an instance of object order.

    //set items takes observable list type
    //

    //coffee.setNumber(a_ordernumber);
/*
    public Order(ArrayList<MenuItem> orderlist ){
        //orderNumber = orderNumber++;
        //orderNum = String.valueOf(orderNumber);
        this.orderlist = orderlist;
        //this.orderNum = orderNum;
    }
*/
    public static void increment(){
        orderCount++;
    }

    public static int getCounter(){
        return orderCount;
    }

    public Order(ArrayList<MenuItem> orderList){
        this.orderlist = orderList;
        this.orderNumber = orderCount;
        this.totalPrice = 0;
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

    public ArrayList<MenuItem> getList() {
        return this.orderlist;
    }
}