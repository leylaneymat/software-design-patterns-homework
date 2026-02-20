package abstractfactory;

public class LuxuryLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("LuxuryLight (Glass) is on.");
    }

    @Override
    public String getDeviceName() {
        return "Luxury Light";
    }
}
