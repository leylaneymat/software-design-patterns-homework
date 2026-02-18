package Homework;
public class FastCargoApp {

    public static void main(String[] args) {
        String type = "SEA";
        Logistics logistics;

        if (type.equals("SEA")) {
            logistics = new SeaLogistics();
        } else {
            logistics = new RoadLogistics();
        }

        logistics.planDelivery();
    }
}