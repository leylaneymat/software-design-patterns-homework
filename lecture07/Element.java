package lecture07;

public class Element {

    public interface Button {
        void paint();
    }

    public interface Checkbox {
        void paint();
    }

    public static class WinButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a square Windows Button.");
        }
    }

    public static class WinCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a Windows Checkbox.");
        }
    }

    public static class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a round Mac Button.");
        }
    }

    public static class MacCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a Mac Checkbox.");
        }
    }
}
