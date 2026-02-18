package Classwork;

public class Checkbox implements Element {
    String os = System.getProperty("os.name");

    @Override
    public void load() {
        System.out.println("Checkbox loaded for " + os);
    }
}
