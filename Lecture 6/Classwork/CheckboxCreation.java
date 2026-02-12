package Classwork;

public abstract class CheckboxCreation extends CreateElement {
    @Override
    protected Element createElement() {
        System.out.println("Checkbox created");
        return new Checkbox();
    }
}
