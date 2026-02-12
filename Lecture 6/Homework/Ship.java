package Homework;
public class Ship implements Transport {

    private String id;

    public Ship(String id) {
        this.id = id;
    }

    @Override
    public void deliver() {
        System.out.println("Delivery by SHIP | id=" + id);
    }
}