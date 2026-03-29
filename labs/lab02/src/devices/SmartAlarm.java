package omnihome.devices;

import java.util.Map;

import omnihome.observer.Observer;
import omnihome.strategy.AlertStrategy;

public class SmartAlarm implements Observer {
    private final Map<String, AlertStrategy> alertRegistry;
    private AlertStrategy currentStrategy;
    private boolean armed;

    public SmartAlarm(Map<String, AlertStrategy> alertRegistry) {
        this.alertRegistry = alertRegistry;
    }

    @Override
    public void update() {
        if (!armed) {
            System.out.println("Alarm received motion event but is currently disarmed.");
            return;
        }

        if (currentStrategy == null) {
            throw new IllegalStateException("No alert strategy configured for the smart alarm.");
        }

        System.out.println("Smart alarm reacting to motion.");
        currentStrategy.executeAlert();
    }

    public void setAlertStrategy(String securityLevel) {
        AlertStrategy strategy = alertRegistry.get(securityLevel);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown security level: " + securityLevel);
        }
        currentStrategy = strategy;
        System.out.println("Alarm strategy set to " + securityLevel + ".");
    }

    public void arm() {
        armed = true;
        System.out.println("Smart alarm is now ARMED.");
    }

    public void disarm() {
        armed = false;
        System.out.println("Smart alarm is now DISARMED.");
    }

    public boolean isArmed() {
        return armed;
    }
}
