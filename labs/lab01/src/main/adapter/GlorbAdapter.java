package adapter;

import abstractfactory.SmartThermostat;

public class GlorbAdapter implements SmartThermostat {
    private final GlorbThermostat glorbThermostat;

    public GlorbAdapter(GlorbThermostat glorbThermostat) {
        this.glorbThermostat = glorbThermostat;
    }

    @Override
    public void setTemperature(double celsius) {
        int fahrenheit = (int) Math.round((celsius * 9 / 5) + 32);
        glorbThermostat.setHeatIndex(fahrenheit);
    }

    @Override
    public String getDeviceName() {
        return "Glorb Legacy Thermostat (Adapted)";
    }
}
