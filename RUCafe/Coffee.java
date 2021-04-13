package RUCafe;

import java.util.ArrayList;

/**
 * This class extends menuitem that encapsulates the datafields and method for a coffee order.
 * @author Siddhi Kasera, Sonal Madhok
 */
public class Coffee extends MenuItem implements Customizable{

    private String size;

    private double price;
    private int numAddOn;
    protected int qty;
    private final double shortPrice = 1.99;
    private final double tallPrice = 2.49;
    private final double grandePrice = 2.99;
    private final double ventiPrice = 3.49;
    private final double addInCost = 0.20;
    private ArrayList<String> addInsList = new ArrayList<String>();


    public Coffee() {

    }

    /**
     * A four parameter coffee constructor.
     * @param size of the coffee
     * @param qty of the coffee ordered
     * @param addInList list of add in list
     * @param numAddOn total num of adds nos.
     */

    public Coffee(String size, int qty, ArrayList<String> addInList, int numAddOn) {
        super();
        this.size = size;
        this.qty = qty;
        this.addInsList = addInsList;
        this.numAddOn = numAddOn;
    }

    /**
     * setter method to set the num of addons for a coffee.
     * @param numAddOn num of add ins selected by the customer
     */
    public void setNumAddOn(int numAddOn) {
        this.numAddOn = numAddOn;
    }

    /**
     * getter method to get the size of coffee.
     * @return the size of the coffee selected.
     */
    public String getSize(){
        return this.size;
    }

    /**
     * getter method that returns the price of a coffee.
     * @return
     */
    public double getCoffeePrice(){
        return price;
    }


    /**
     * Calculates the price of coffee
     */
    public void itemPrice(){

        price = numAddOn * addInCost;

        if(size.equals("Short")){
            price = (price + shortPrice) * qty;// 1.99
        }else if(size.equals("Tall")){
            price = (price + tallPrice) * qty;
        }else if(size.equals("Grande")){
           price = (price + grandePrice) * qty;
        }else if(size.equals("Venti")){
            price = (price + ventiPrice) * qty;
        }

    }

    public void setPrice(double price){
        this.price = price;
    }
    /**
     * Adds addins to a list for a coffee
     * @param obj addIns
     * @return true if the item is added
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof String){
            addInsList.add((String) obj);
            numAddOn++;
        }
        return true;
    }
    /**
     * removes addins to a list for a coffee
     * @param obj addIns
     * @return true if the item is removed
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String){
            addInsList.remove((String) obj);
            numAddOn--;
        }
        return true;
    }

    /**
     * Returns a string representation of this coffee order
     * @return string representation of this coffee order
     */
    @Override
    public String toString(){
      return (  "Size "+ this.size +  "\n " +
               " Quantity " +  this.qty + "\n " + " addins "+this.addInsList);
    }
}