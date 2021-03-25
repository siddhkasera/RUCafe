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
    private final double addInCost = 0.20;
    private final double sizeCost = 0.50;



    public Coffee(String size, String cream, String syrup, String milk, String caramel, String whippedCream ){
        super();
        this.size = size;
        this.cream = cream;
        this.syrup = syrup;
        this.milk = milk;
        this.caramel = caramel;
        this.whippedCream = whippedCream;
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
            price = price + shortPrice;
        }else if(size.equals("tall") || size.equals("grande") || size.equals("venti")){
            price = price + shortPrice + sizeCost;
        }

    }


    @Override
    public boolean add(Object obj) {

        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
