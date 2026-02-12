package Classwork;

public class Button implements Element {
    String os = System.getProperty("os.name");

    @Override
    public void load() {
        System.out.println("Checkbox loaded for " + os);
    }
}
