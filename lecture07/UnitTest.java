package lecture07;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    void testWinDarkFactoryCreatesCorrectButton() {
        Element.Button button = GUIFactory.WinDarkFactory.getInstance().createButton("Save");
        assertTrue(button instanceof Element.WinDarkButton);
    }

    @Test
    void testWindowBuilderComponentCount() {
        Window window = new WindowBuilder(GUIFactory.WinDarkFactory.getInstance())
                .addTitle("Settings")
                .addButton("Save")
                .addButton("Cancel")
                .addCheckbox("Enable notifications")
                .addProgressBar(50)
                .build();

        assertEquals(5, window.componentCount());
    }
}
