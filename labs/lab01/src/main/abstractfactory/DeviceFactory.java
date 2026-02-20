package abstractfactory;

public interface DeviceFactory {
    SmartLight createLight();
    SmartLock createLock();
    SmartThermostat createThermostat();
}
