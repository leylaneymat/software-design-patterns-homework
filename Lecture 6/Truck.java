public class Truck implements Transport {

    private String id;

    public Truck(String id) {
        this.id = id;
    }

    @Override
    public void deliver() {
        System.out.println("Delivery by TRUCK | id=" + id);
    }
}