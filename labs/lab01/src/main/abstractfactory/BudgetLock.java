package abstractfactory;

public class BudgetLock implements SmartLock {
    @Override
    public void lock() {
        System.out.println("BudgetLock (No camera) is locked.");
    }

    @Override
    public String getDeviceName() {
        return "Budget Lock";
    }
}
