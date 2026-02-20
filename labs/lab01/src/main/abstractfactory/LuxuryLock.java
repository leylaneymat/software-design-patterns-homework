package abstractfactory;

public class LuxuryLock implements SmartLock {
    @Override
    public void lock() {
        System.out.println("LuxuryLock (Face ID) is locked.");
    }

    @Override
    public String getDeviceName() {
        return "Luxury Lock";
    }
}
