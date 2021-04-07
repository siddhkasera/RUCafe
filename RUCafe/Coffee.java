package RUCafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable{

    private String size;
    private String cream;
    private String syrup;
    private String milk;
    private String caramel;
    private String whippedCream;
    private double price;
    private int numAddOn;
    protected int qty;
    private final double shortPrice = 1.99;
    private final double tallPrice = 2.49;
    private final double grandePrice = 2.99;
    private final double ventiPrice = 3.49;
    private final double addInCost = 0.20;
    // private final double sizeCost = 0.50;
    private ArrayList<String> addInsList = new ArrayList<String>();
    Addins addIn;

    //public Coffee(String size, String cream, String syrup, String milk, String caramel, String whippedCream ){

    public Coffee() {

    }

    public Coffee(String size, Addins addIn){
        super();
        this.size = size;
        this.addIn = addIn;
        //this.addInsList = addInsList;
    }


    public Coffee(String size, String cream, String syrup, String milk, String caramel, String whippedCream, int qty) {
        super();
        this.size = size;
        this.cream = cream;
        this.syrup = syrup;
        this.milk = milk;
        this.caramel = caramel;
        this.whippedCream = whippedCream;
        this.qty = qty;
    }

   /* public Coffee(int numAddOn){
        this.numAddOn = numAddOn;
    }

    */

    public Coffee(String size, int qty, ArrayList<String> addInList, int numAddOn) {
        //super("Coffee");
        super();
        this.size = size;
        this.qty = qty;
        this.addInsList = addInsList;
        this.numAddOn = numAddOn;
    }

    public void setNumAddOn(int numAddOn) {
        this.numAddOn = numAddOn;
    }

    public int getNumAddOn(){
        return numAddOn;
    }

    public String getSize(){
        return this.size;
    }

    public ArrayList<String> getList(){
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < addInsList.size(); i++) {
            list.add(addInsList.get(i));

        }

        return list;
    }


    public void itemPrice(){

        price = numAddOn * addInCost;
        //System.out.println("Price in coffee is"+ price);

        if(size.equals("Short")){
            price = (price + shortPrice) * qty;// 1.99
        }else if(size.equals("Tall")){
            //System.out.println("Inside tall");
            price = (price + tallPrice) * qty;
        }else if(size.equals("Grande")){
           price = (price + grandePrice) * qty;
        }else if(size.equals("Venti")){
            price = (price + ventiPrice) * qty;
        }
        System.out.println("Price in coffee is"+ price);


    }

    public void setPrice(){
        this.price = price;
    }
    public double getprice(){
        return price;
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof String){
            addInsList.add((String) obj);
            numAddOn++;
        }
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof String){
            addInsList.remove((String) obj);
            numAddOn--;
        }
        return true;
    }

    @Override
    public String toString(){
      return (  this.size + this.qty + this.addInsList);
    }
}