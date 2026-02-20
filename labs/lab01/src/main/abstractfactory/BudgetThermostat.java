package abstractfactory;

public class BudgetThermostat implements SmartThermostat {
    @Override
    public void setTemperature(double temp) {
        System.out.println("BudgetThermostat (Slow) set to " + temp + " C.");
    }

    @Override
    public String getDeviceName() {
        return "Budget Thermostat";
    }
}
