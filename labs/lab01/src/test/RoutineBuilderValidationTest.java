import abstractfactory.BudgetLight;
import builder.RoutineBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoutineBuilderValidationTest extends ClassFileCleanup {

    @Test
    void buildShouldFailWhenNameIsMissing() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                new RoutineBuilder()
                        .addDevice(new BudgetLight())
                        .atTime("08:00")
                        .toggleNotification(true)
                        .build()
        );

        assertEquals("Routine name is required.", exception.getMessage());
    }

    @Test
    void buildShouldFailWhenNoDevicesProvided() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                new RoutineBuilder()
                        .withName("No Devices")
                        .atTime("08:00")
                        .toggleNotification(true)
                        .build()
        );

        assertEquals("At least one device is required.", exception.getMessage());
    }

    @Test
    void buildShouldFailWhenTriggerTimeIsMissing() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                new RoutineBuilder()
                        .withName("Missing Time")
                        .addDevice(new BudgetLight())
                        .toggleNotification(true)
                        .build()
        );

        assertEquals("Trigger time is required.", exception.getMessage());
    }
}
