package lecture07;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfig {

    public static GUIFactory loadFactory() {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("lecture07/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            return GUIFactory.WinLightFactory.getInstance();
        }

        String os = properties.getProperty("os").toUpperCase();
        String theme = properties.getProperty("theme").toUpperCase();

        if (os.equals("WINDOWS") && theme.equals("LIGHT")) {
            return GUIFactory.WinLightFactory.getInstance();
        }
        if (os.equals("WINDOWS") && theme.equals("DARK")) {
            return GUIFactory.WinDarkFactory.getInstance();
        }
        if (os.equals("MAC") && theme.equals("LIGHT")) {
            return GUIFactory.MacLightFactory.getInstance();
        }
        if (os.equals("MAC") && theme.equals("DARK")) {
            return GUIFactory.MacDarkFactory.getInstance();
        }
        if (os.equals("LINUX") && theme.equals("LIGHT")) {
            return GUIFactory.LinuxLightFactory.getInstance();
        }
        if (os.equals("LINUX") && theme.equals("DARK")) {
            return GUIFactory.LinuxDarkFactory.getInstance();
        }

        throw new IllegalArgumentException("Unsupported OS or theme: " + os + ", " + theme);
    }
}
