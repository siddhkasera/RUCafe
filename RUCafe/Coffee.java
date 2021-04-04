package RUCafe;

import java.util.ArrayList;

import static RUCafe.Addins.*;

public class Coffee extends MenuItem implements Customizable{

    private String size;
    private String cream;
    private String syrup;
    private String milk;
    private String caramel;
    private String whippedCream;
    private double price;
    private int numAddOn;
    private final double shortPrice = 1.99;
    private final double tallPrice = 2.49;
    private final double grandePrice = 2.99;
    private final double ventiPrice = 3.49;
    private final double addInCost = 0.20;
   // private final double sizeCost = 0.50;
    private ArrayList<String> addInsList = new ArrayList<String>();


    Addins addIn;

    //
    //public Coffee(String size, String cream, String syrup, String milk, String caramel, String whippedCream ){

      public Coffee(String size, Addins addIn){
        super();
        this.size = size;
        this.addIn = addIn;
        //this.syrup = syrup;
        //this.milk = milk;
        //this.caramel = caramel;
        //this.whippedCream = whippedCream;
    }
    public Coffee(int numAddOn){
        super();
        this.numAddOn = numAddOn;
    }

    public String getSize(){
        return this.size;
    }

    public void itemPrice(){

        price = numAddOn * addInCost;

        if(size.equals("short")){
            price = price + shortPrice;// 1.99
        }else if(size.equals("tall")){
            price = price + tallPrice;
        }else if(size.equals("grande")){
           price = price + grandePrice;
        }else if(size.equals("venti")){
            price = price + ventiPrice;
        }
    }


    @Override
    public boolean add(Object obj) {
        if (obj instanceof Addins){
            addInsList.add((String) obj);
            numAddOn++;
        }
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Addins){
            addInsList.remove((String) obj);
            numAddOn--;
        }
          return true;
    }
}