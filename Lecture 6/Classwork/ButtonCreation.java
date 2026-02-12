package Classwork;

public class ButtonCreation extends CreateElement {
    @Override
    protected Element createElement() {
        System.out.println("Button created");
        return new Button();
    }
}
