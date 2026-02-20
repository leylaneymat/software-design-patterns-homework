package abstractfactory;

public class BudgetLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("BudgetLight (Plastic) is on.");
    }

    @Override
    public String getDeviceName() {
        return "Budget Light";
    }
}
