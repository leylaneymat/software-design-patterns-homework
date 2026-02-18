package lecture07;

public class Application {
    private final GUIFactory factory;

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    public Window createSettingsWindow() {
        return new WindowBuilder(factory)
                .addTitle("J-Code settings")
                .addCheckbox("Auto save")
                .addCheckbox("Show line numbers")
                .addProgressBar(40)
                .addButton("Apply")
                .addButton("Cancel")
                .build();
    }
}
