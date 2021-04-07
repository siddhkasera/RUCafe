package RUCafe;

/**
 * Encapsulates the data fields of the menuitem.
 * @author Siddhi Kasera and Sonal Madhok
 */
public class MenuItem {
    private String menuItem;
    private int number;
    private int price;

    /**
     * Two parameter constructor for menuitem
     * @param menuItem
     * @param price
     */
    public MenuItem(String menuItem, int price){
        this.menuItem = menuItem;
        this.price = price;
    }

    public MenuItem() {
    }

    /**
     * getter method to get the menuitem
     * @return menuitem
     */
    public String getItem(){
        return this.menuItem;
    }

    /**
     * gets the price of menu items.
     * @return price
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Returns a string representation of menuitem
     * @return string
     */
    @Override
    public String toString(){
        return this.menuItem;
    }


}