public class Donut extends MenuItem{

    private String type;
    private double price;
    private final double yeastPrice = 1.39;
    private final double cakePrice = 1.59;
    private final double donutHolePrice = 0.33;


    public Donut(String type){
        super();
        this.type = type;
    }
    public void itemPrice(){
        if(type.equals("yeast")) {
            price = yeastPrice;
        }else if(type.equals("cake")){
            price = cakePrice;
        }else if(type.equals("holes")){
            price = donutHolePrice;
        }
    }
    public String getType(){
        return this.type;
    }

}
