import java.awt.*;

public class Order implements Customizable {
    private int orderCount;
    private static final int CAPACITY = 4;
    private MenuItem [] orderList;
    //list of menu items added.
    private static int orderNumber = 10000;
    public static String orderNum = "10000";
    MenuItem menuitem = new MenuItem();

    public Order(int orderNumber){
        //this.orderNumber = orderNumber;
        orderList = new MenuItem[CAPACITY];
        orderCount = 0;

    }


    @Override
    public boolean add(Object obj) {
        if(obj instanceof MenuItem){
            MenuItem menuItem = new MenuItem();
            menuItem = (MenuItem) obj;
            if((orderCount + 1) <=  orderList.length) {
                orderList[orderCount] = menuItem;
                orderNumber++;
                orderNum = String.valueOf(orderNumber);
                menuitem.setNumber(orderNum);


            }

        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
