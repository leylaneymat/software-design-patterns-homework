import org.junit.jupiter.api.Test;
import prototype.Configuration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class ConfigurationPrototypeTest extends ClassFileCleanup {

    @Test
    void cloneShouldCreateIndependentCopy() {
        Configuration original = new Configuration("192.168.1.10", 8080, "v1.4.0");
        Configuration copy = original.clone();
        copy.setIpAddress("192.168.1.22");

        assertNotSame(original, copy);
        assertEquals("192.168.1.10", original.getIpAddress());
        assertEquals("192.168.1.22", copy.getIpAddress());
    }
}
