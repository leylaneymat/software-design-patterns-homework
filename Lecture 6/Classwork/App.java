package Classwork;

public class App {

    public void createElement(Element element) {
        element.load();
    }

    public static void main(String[] args) {
        App app = new App();

        app.createElement(new Checkbox());
        app.createElement(new Button());
    }
}