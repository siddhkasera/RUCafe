package RUCafe;


public class MenuItem {
    private String menuItem;
    private int number;
    private int price;

    public MenuItem(String menuItem, int price){
        this.menuItem = menuItem;
        this.price = price;
    }

    public MenuItem() {
    }

    public String getItem(){
        return this.menuItem;
    }
    public int getPrice(){
        return this.price;
    }
    public void setNumber(int number){
        this.number = number;
    }

    public void setPrice(double price) {

    }

    public void itemPrice(){

    }
    @Override
    public String toString(){
        return this.menuItem;
    }
/*
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem menuitem = (MenuItem) obj;
            if (this.menuItem.equals(menuitem.menuItem)) {
                return true;
            }
        }
        return false;
    }

 */

}