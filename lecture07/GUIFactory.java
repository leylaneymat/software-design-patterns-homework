package lecture07;
import static lecture07.Element.*;

import lecture07.Element.Button;

public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();

    class WinFactory implements GUIFactory {

        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }

    class MacFactory implements GUIFactory {

        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }
}
