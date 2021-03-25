
public class StoreOrders implements Customizable{

    private Order[] orderList = new Order[]; //order list..not sure if it is suppose to be a order object.

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}

