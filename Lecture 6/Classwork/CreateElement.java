package Classwork;

public abstract class CreateElement {
    
    public void startLoading() {
        Element checkbox = createElement();
        checkbox.load();
    }

    protected abstract Element createElement();
}