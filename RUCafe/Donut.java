package RUCafe;

import java.util.ArrayList;

/**
 * This class extends menuitem that encapsulates the datafields and method for a donut order.
 * @author Siddhi Kasera, Sonal Madhok
 */

public class Donut extends MenuItem implements Customizable{

    private String type;
    private String flavor; //chocolate, strawberry, sugar_glazed.
    private double price;
    private final double yeastPrice = 1.39;
    private final double cakePrice = 1.59;
    private final double donutHolePrice = 0.33;
    private int quantity;
    private ArrayList<Integer> quantityList = new ArrayList<Integer>();


    /**
     * Three parameter constructor for donut
     * @param type type of donut
     * @param flavor flavor of donut
     * @param quantityList quantity of donut selected
     */
    public Donut(String type, String flavor, ArrayList<Integer> quantityList){
        super();
        this.type = type;
        this.flavor = flavor;
        this.quantityList = quantityList;
    }

    /**
     * Calculates the price for donuts.
     */
    public void itemPrice(){
        if(type.equals("yeast")) {
            price = yeastPrice * quantity;
        }else if(type.equals("cake")){
            price = cakePrice * quantity;
        }else if(type.equals("holes")){
            price = donutHolePrice * quantity;
        }
    }
    public double getDonutPrice(){
        return price;
    }
    /**
     * Adds the quantity of donuts in a list
     * @param obj to be added in the list
     * @return
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Integer){
            quantityList.add((Integer) obj);
            quantity++;
        }
        return true;
    }

    /**
     * removes the quantity of donuts in a list
     * @param obj to be added in the list
     * @return returns true if successfully added.
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Integer){
            quantityList.remove((String) obj);
            quantity--;
        }
        return true;
    }

    /**
     * Returns string form of the object
     * @return string
     */
    @Override
    public String toString(){
        return (  this.type + " "+ this.flavor + " " + this.quantityList);
    }
}