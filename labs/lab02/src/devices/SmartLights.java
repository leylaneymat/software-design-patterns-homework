package omnihome.devices;

import omnihome.observer.Observer;

public class SmartLights implements Observer {
    private boolean on;

    @Override
    public void update() {
        turnOn();
        System.out.println("Smart lights detected motion and illuminated the room.");
    }

    public void turnOn() {
        on = true;
        System.out.println("Smart lights are now ON.");
    }

    public void turnOff() {
        on = false;
        System.out.println("Smart lights are now OFF.");
    }

    public boolean isOn() {
        return on;
    }
}
