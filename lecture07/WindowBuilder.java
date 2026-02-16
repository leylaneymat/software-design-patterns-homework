package lecture07;
import java.util.ArrayList;
import java.util.List;
import lecture07.Element.UIComponent;

public class WindowBuilder {
    private final GUIFactory factory;
    private final List<UIComponent> components = new ArrayList<>();

    public WindowBuilder(GUIFactory factory) {
        this.factory = factory;
    }

    public WindowBuilder addTitle(String text) {
        components.add(factory.createTitle(text));
        return this;
    }

    public WindowBuilder addButton(String text) {
        components.add(factory.createButton(text));
        return this;
    }

    public WindowBuilder addCheckbox(String label) {
        components.add(factory.createCheckbox(label));
        return this;
    }

    public WindowBuilder addProgressBar(int initialValue) {
        components.add(factory.createProgressBar(initialValue));
        return this;
    }

    public Window build() {
        return new Window(components);
    }
}
