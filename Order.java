package RUCafe;


import java.util.ArrayList;

/**
 * Encapsulates the data fields and methods for order class.
 * @author Siddhi Kasera and Sonal Madhok
 */
public class Order implements Customizable {
    protected static int orderCount = 1;
    private int orderNumber;
    private double totalPrice;

    private ArrayList<MenuItem> orderlist;

    /**
     * One parameter constructor for order.
     *
     * @param orderlist of menuitems
     */
    public Order(ArrayList<MenuItem> orderlist) {
        this.orderlist = orderlist;
        this.orderNumber = orderCount;
        this.totalPrice = 0;
    }

    /**
     * increments the order number.
     */
    public static void setIncrement() {
        orderCount++;
    }

    /**
     * retuen the order number
     *
     * @return order number
     */
    public static int getOrderCount() {
        return orderCount;
    }


    /**
     * returns the total price for an order
     *
     * @return prive for an order
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * sets the total price of the total price
     *
     * @param totalPrice of the order
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * returns the order number for an order
     *
     * @return
     */
    public static int getCounter() {
        return orderCount;
    }

    /**
     * Setter method to set the list for an order
     *
     * @param list of the order
     */
    public void setList(ArrayList<MenuItem> list) {
        this.orderlist = new ArrayList<MenuItem>(list);
    }

    /**
     * gets the item in the list.
     *
     * @return array list of items
     */
    public ArrayList<MenuItem> getItems() {
        return orderlist;
    }

    /**
     * adds the menu items to the order list.
     *
     * @param obj to be added in the list
     * @return true if successfully added.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Coffee || obj instanceof Donut) {
            orderlist.add((MenuItem) obj);
            //orderCount++;
            return true;
        }
        return false;
    }

    /**
     * removes the menu items from the list
     *
     * @param obj to be removed
     * @return true if successfully removed.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof MenuItem) {
            orderlist.remove(obj);
            //orderCount--;
            return true;
        }
        return false;
    }

    /**
     * Returns the string representation of an order
     *
     * @return string
     */
    @Override
    public String toString() {
        return "This order contains" + "\n" + this.orderlist + "\n" + this.totalPrice + "\n" + this.orderNumber;
    }


}