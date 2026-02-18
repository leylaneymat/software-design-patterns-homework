package lecture07;

public class GUIApp {
    public static void main(String[] args) {
        GUIFactory factory = FactoryConfig.loadFactory();

        Application application = new Application(factory);
        Window window = application.createSettingsWindow();

        window.paint();
    }
}
