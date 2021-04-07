package RUCafe;

import javafx.scene.control.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Order implements Customizable {
    //private final Object items;
    protected static int orderCount = 0;
    private int orderNumber;
    protected static String orderNum;
    private double totalPrice;
    private MenuItem item;
    private Coffee coffee;
   private ArrayList<MenuItem> orderlist;


     public Order(ArrayList<MenuItem> orderlist){
        this.orderlist = orderlist;
        this.orderNumber = orderCount;
        this.totalPrice = 0;
     }

    public static void setIncrement(){
         orderCount++;
    }
    public static int getOrderCount(){
         return orderCount;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }


    public double getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public static int getCounter() {
        return orderCount;
    }
    public void setList(ArrayList<MenuItem> list){
        this.orderlist = new ArrayList<MenuItem>(list);
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
        if (obj instanceof MenuItem) {
            orderlist.remove(obj);
            //orderCount--;
            return true;
        }
        return false;
    }

    public ArrayList<MenuItem> getItems(){
        return orderlist;
    }
    public ArrayList<String> getList() {

        //return new ArrayList<MenuItem>(this.orderlist);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < orderlist.size(); i++) {
            list.add(orderlist.get(i).getItem());
        }

        return list;
    }
    @Override
    public String toString(){
        return "This order contains"+ "\n" +this.orderlist+ "\n" + this.totalPrice + "\n" + this.orderNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem menuitem = (MenuItem) obj;
            for(int i = 0; i<this.orderlist.size(); i++){
            if (this.orderlist.get(i).equals(menuitem)) {
                return true;
            }
            }
        }
        return false;
    }



}