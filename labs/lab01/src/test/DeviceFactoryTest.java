import abstractfactory.BudgetFactory;
import abstractfactory.BudgetLight;
import abstractfactory.BudgetLock;
import abstractfactory.BudgetThermostat;
import abstractfactory.DeviceFactory;
import abstractfactory.LuxuryFactory;
import abstractfactory.LuxuryLight;
import abstractfactory.LuxuryLock;
import abstractfactory.LuxuryThermostat;
import abstractfactory.SmartLight;
import abstractfactory.SmartLock;
import abstractfactory.SmartThermostat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class DeviceFactoryTest extends ClassFileCleanup {

    @Test
    void budgetFactoryShouldCreateBudgetDevices() {
        DeviceFactory budgetFactory = new BudgetFactory();
        SmartLight light = budgetFactory.createLight();
        SmartLock lock = budgetFactory.createLock();
        SmartThermostat thermostat = budgetFactory.createThermostat();

        assertInstanceOf(BudgetLight.class, light);
        assertInstanceOf(BudgetLock.class, lock);
        assertInstanceOf(BudgetThermostat.class, thermostat);
    }

    @Test
    void luxuryFactoryShouldCreateLuxuryDevices() {
        DeviceFactory luxuryFactory = new LuxuryFactory();
        SmartLight light = luxuryFactory.createLight();
        SmartLock lock = luxuryFactory.createLock();
        SmartThermostat thermostat = luxuryFactory.createThermostat();

        assertInstanceOf(LuxuryLight.class, light);
        assertInstanceOf(LuxuryLock.class, lock);
        assertInstanceOf(LuxuryThermostat.class, thermostat);
    }
}
