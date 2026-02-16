package lecture07;

public class GUIApp {

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            factory = new GUIFactory.MacFactory();
        } else if (osName.contains("win")) {
            factory = new GUIFactory.WinFactory();
        } else {
            throw new RuntimeException("Unrecognized OS: " + osName);
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
