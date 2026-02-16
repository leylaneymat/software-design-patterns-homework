package lecture07;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lecture07.Element.UIComponent;

public class Window {
    private final List<UIComponent> components;

    public Window(List<UIComponent> components) {
        this.components = new ArrayList<>(components);
    }

    public List<UIComponent> getComponents() {
        return Collections.unmodifiableList(components);
    }

    public int componentCount() {
        return components.size();
    }

    public void paint() {
        System.out.println("Window:");
        for (UIComponent component : components) {
            System.out.println("- " + component.paint());
        }
    }
}
