import abstractfactory.BudgetLight;
import abstractfactory.BudgetLock;
import abstractfactory.BudgetThermostat;
import abstractfactory.LuxuryLight;
import abstractfactory.LuxuryLock;
import abstractfactory.LuxuryThermostat;
import adapter.GlorbAdapter;
import adapter.GlorbThermostat;
import org.junit.jupiter.api.Test;
import singleton.CloudConnection;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeviceBehaviorTest extends ClassFileCleanup {

    @Test
    void devicesShouldExposeExpectedNames() {
        assertEquals("Budget Light", new BudgetLight().getDeviceName());
        assertEquals("Budget Lock", new BudgetLock().getDeviceName());
        assertEquals("Budget Thermostat", new BudgetThermostat().getDeviceName());
        assertEquals("Luxury Light", new LuxuryLight().getDeviceName());
        assertEquals("Luxury Lock", new LuxuryLock().getDeviceName());
        assertEquals("Luxury Thermostat", new LuxuryThermostat().getDeviceName());
        assertEquals("Glorb Legacy Thermostat (Adapted)", new GlorbAdapter(new GlorbThermostat()).getDeviceName());
    }

    @Test
    void commandMethodsShouldExecuteAndSingletonShouldKeepInitialConfig() throws Exception {
        BudgetLight budgetLight = new BudgetLight();
        BudgetLock budgetLock = new BudgetLock();
        BudgetThermostat budgetThermostat = new BudgetThermostat();
        LuxuryLight luxuryLight = new LuxuryLight();
        LuxuryLock luxuryLock = new LuxuryLock();
        LuxuryThermostat luxuryThermostat = new LuxuryThermostat();

        budgetLight.turnOn();
        budgetLock.lock();
        budgetThermostat.setTemperature(19.5);
        luxuryLight.turnOn();
        luxuryLock.lock();
        luxuryThermostat.setTemperature(22.0);

        resetSingleton();
        CloudConnection first = CloudConnection.getInstance("API-ONE", "https://one");
        CloudConnection second = CloudConnection.getInstance("API-TWO", "https://two");
        first.connect();

        assertEquals("API-ONE", second.getApiKey());
        assertEquals("https://one", second.getServerUrl());
    }

    private static void resetSingleton() throws Exception {
        Field instanceField = CloudConnection.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
    }
}
