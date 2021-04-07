package RUCafe;

import java.util.ArrayList;

//changes added flavor.
public class Donut extends MenuItem implements Customizable{

    private String type;
    private String flavor; //chocolate, strawberry, sugar_glazed.
    private double price;
    private final double yeastPrice = 1.39;
    private final double cakePrice = 1.59;
    private final double donutHolePrice = 0.33;
    private int quantity;
    private ArrayList<Integer> quantityList = new ArrayList<Integer>();



    public Donut(String type, String flavor, ArrayList<Integer> quantity){
        super();
        this.type = type;
        this.flavor = flavor;
        this.quantityList = quantityList;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void itemPrice(){
        if(type.equals("yeast")) {
            price = yeastPrice * quantity;
        }else if(type.equals("cake")){
            price = cakePrice * quantity;
        }else if(type.equals("holes")){
            price = donutHolePrice * quantity;
        }
    }
    public String getType(){
        return this.type;
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Integer){
            quantityList.add((Integer) obj);
            quantity++;
        }
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Integer){
            quantityList.remove((String) obj);
            quantity--;
        }
        return true;
    }

    @Override
    public String toString(){
        return (  this.type + " "+ this.flavor + " " + this.quantityList);
    }
}