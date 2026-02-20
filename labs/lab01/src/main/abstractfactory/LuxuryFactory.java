package abstractfactory;

public class LuxuryFactory implements DeviceFactory {
    @Override
    public SmartLight createLight() {
        return new LuxuryLight();
    }

    @Override
    public SmartLock createLock() {
        return new LuxuryLock();
    }

    @Override
    public SmartThermostat createThermostat() {
        return new LuxuryThermostat();
    }
}
