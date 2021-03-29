package RUCafe;

//changes added flavor.
public class Donut extends MenuItem{

    private String type;
    private String flavor; //chocolate, strawberry, sugar_glazed.
    private double price;
    private final double yeastPrice = 1.39;
    private final double cakePrice = 1.59;
    private final double donutHolePrice = 0.33;
    private int quantity;


    public Donut(String type, String flavor, int quantity){
        super();
        this.type = type;
        this.flavor = flavor;
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

}