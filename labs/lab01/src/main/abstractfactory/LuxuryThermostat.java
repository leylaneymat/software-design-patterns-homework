package abstractfactory;

public class LuxuryThermostat implements SmartThermostat {
    @Override
    public void setTemperature(double temp) {
        System.out.println("LuxuryThermostat (AI-powered) set to " + temp + " C.");
    }

    @Override
    public String getDeviceName() {
        return "Luxury Thermostat";
    }
}
