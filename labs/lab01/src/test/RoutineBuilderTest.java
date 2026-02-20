import abstractfactory.BudgetLight;
import abstractfactory.BudgetLock;
import abstractfactory.BudgetThermostat;
import adapter.GlorbAdapter;
import adapter.GlorbThermostat;
import builder.AutomationRoutine;
import builder.RoutineBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoutineBuilderTest extends ClassFileCleanup {

    @Test
    void shouldBuildVacationModeWithFourDevices() {
        AutomationRoutine routine = new RoutineBuilder()
                .withName("Vacation Mode")
                .addDevice(new BudgetLight())
                .addDevice(new BudgetLock())
                .addDevice(new BudgetThermostat())
                .addDevice(new GlorbAdapter(new GlorbThermostat()))
                .atTime("08:00")
                .toggleNotification(true)
                .build();

        assertEquals("Vacation Mode", routine.getName());
        assertEquals(4, routine.getDevices().size());
        assertEquals("08:00", routine.getTriggerTime());
        assertTrue(routine.isSendNotification());
        assertTrue(routine.toString().contains("devicesCount=4"));
    }
}
