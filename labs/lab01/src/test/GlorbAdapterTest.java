import adapter.GlorbAdapter;
import adapter.GlorbThermostat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GlorbAdapterTest extends ClassFileCleanup {

    @Test
    void shouldConvertCelsiusToFahrenheit() {
        GlorbThermostat legacy = new GlorbThermostat();
        GlorbAdapter adapter = new GlorbAdapter(legacy);
        adapter.setTemperature(25.0);
        assertEquals(77, legacy.getLastHeatIndex());
    }
}
