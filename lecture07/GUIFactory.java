package lecture07;
import static lecture07.Element.Button;
import static lecture07.Element.Checkbox;
import static lecture07.Element.LinuxDarkButton;
import static lecture07.Element.LinuxDarkCheckbox;
import static lecture07.Element.LinuxDarkProgressBar;
import static lecture07.Element.LinuxLightButton;
import static lecture07.Element.LinuxLightCheckbox;
import static lecture07.Element.LinuxLightProgressBar;
import static lecture07.Element.MacDarkButton;
import static lecture07.Element.MacDarkCheckbox;
import static lecture07.Element.MacDarkProgressBar;
import static lecture07.Element.MacLightButton;
import static lecture07.Element.MacLightCheckbox;
import static lecture07.Element.MacLightProgressBar;
import static lecture07.Element.ProgressBar;
import static lecture07.Element.SimpleTitle;
import static lecture07.Element.Title;
import static lecture07.Element.WinDarkButton;
import static lecture07.Element.WinDarkCheckbox;
import static lecture07.Element.WinDarkProgressBar;
import static lecture07.Element.WinLightButton;
import static lecture07.Element.WinLightCheckbox;
import static lecture07.Element.WinLightProgressBar;

public interface GUIFactory {

    Button createButton(String text);

    Checkbox createCheckbox(String label);

    ProgressBar createProgressBar(int value);

    Title createTitle(String text);

    String styleName();

    final class WinLightFactory implements GUIFactory {
        private static final WinLightFactory INSTANCE = new WinLightFactory();

        private WinLightFactory() {}

        public static WinLightFactory getInstance() {
            return INSTANCE;
        }

        @Override
        public Button createButton(String text) {
            return new WinLightButton(text);
        }

        @Override
        public Checkbox createCheckbox(String label) {
            return new WinLightCheckbox(label);
        }

        @Override
        public ProgressBar createProgressBar(int value) {
            return new WinLightProgressBar(value);
        }

        @Override
        public Title createTitle(String text) {
            return new SimpleTitle(styleName(), text);
        }

        @Override
        public String styleName() {
            return "Windows Light";
        }
    }

    final class WinDarkFactory implements GUIFactory {
        private static final WinDarkFactory INSTANCE = new WinDarkFactory();

        private WinDarkFactory() {}

        public static WinDarkFactory getInstance() {
            return INSTANCE;
        }

        @Override
        public Button createButton(String text) {
            return new WinDarkButton(text);
        }

        @Override
        public Checkbox createCheckbox(String label) {
            return new WinDarkCheckbox(label);
        }

        @Override
        public ProgressBar createProgressBar(int value) {
            return new WinDarkProgressBar(value);
        }

        @Override
        public Title createTitle(String text) {
            return new SimpleTitle(styleName(), text);
        }

        @Override
        public String styleName() {
            return "Windows Dark";
        }
    }

    final class MacLightFactory implements GUIFactory {
        private static final MacLightFactory INSTANCE = new MacLightFactory();

        private MacLightFactory() {}

        public static MacLightFactory getInstance() {
            return INSTANCE;
        }

        @Override
        public Button createButton(String text) {
            return new MacLightButton(text);
        }

        @Override
        public Checkbox createCheckbox(String label) {
            return new MacLightCheckbox(label);
        }

        @Override
        public ProgressBar createProgressBar(int value) {
            return new MacLightProgressBar(value);
        }

        @Override
        public Title createTitle(String text) {
            return new SimpleTitle(styleName(), text);
        }

        @Override
        public String styleName() {
            return "Mac Light";
        }
    }

    final class MacDarkFactory implements GUIFactory {
        private static final MacDarkFactory INSTANCE = new MacDarkFactory();

        private MacDarkFactory() {}

        public static MacDarkFactory getInstance() {
            return INSTANCE;
        }

        @Override
        public Button createButton(String text) {
            return new MacDarkButton(text);
        }

        @Override
        public Checkbox createCheckbox(String label) {
            return new MacDarkCheckbox(label);
        }

        @Override
        public ProgressBar createProgressBar(int value) {
            return new MacDarkProgressBar(value);
        }

        @Override
        public Title createTitle(String text) {
            return new SimpleTitle(styleName(), text);
        }

        @Override
        public String styleName() {
            return "Mac Dark";
        }
    }

    final class LinuxLightFactory implements GUIFactory {
        private static final LinuxLightFactory INSTANCE = new LinuxLightFactory();

        private LinuxLightFactory() {}

        public static LinuxLightFactory getInstance() {
            return INSTANCE;
        }

        @Override
        public Button createButton(String text) {
            return new LinuxLightButton(text);
        }

        @Override
        public Checkbox createCheckbox(String label) {
            return new LinuxLightCheckbox(label);
        }

        @Override
        public ProgressBar createProgressBar(int value) {
            return new LinuxLightProgressBar(value);
        }

        @Override
        public Title createTitle(String text) {
            return new SimpleTitle(styleName(), text);
        }

        @Override
        public String styleName() {
            return "Linux Light";
        }
    }

    final class LinuxDarkFactory implements GUIFactory {
        private static final LinuxDarkFactory INSTANCE = new LinuxDarkFactory();

        private LinuxDarkFactory() {}

        public static LinuxDarkFactory getInstance() {
            return INSTANCE;
        }

        @Override
        public Button createButton(String text) {
            return new LinuxDarkButton(text);
        }

        @Override
        public Checkbox createCheckbox(String label) {
            return new LinuxDarkCheckbox(label);
        }

        @Override
        public ProgressBar createProgressBar(int value) {
            return new LinuxDarkProgressBar(value);
        }

        @Override
        public Title createTitle(String text) {
            return new SimpleTitle(styleName(), text);
        }

        @Override
        public String styleName() {
            return "Linux Dark";
        }
    }
}
