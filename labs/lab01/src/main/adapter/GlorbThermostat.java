package adapter;

public class GlorbThermostat {
    private int lastHeatIndex;

    public void setHeatIndex(int fahrenheit) {
        this.lastHeatIndex = fahrenheit;
        System.out.println("Glorb legacy thermostat heat index set to " + fahrenheit + " F.");
    }

    public int getLastHeatIndex() {
        return lastHeatIndex;
    }
}
