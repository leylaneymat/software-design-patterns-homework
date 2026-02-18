package lecture07;

public class Element {

    public interface UIComponent {
        String paint();
    }

    public interface Title extends UIComponent {}

    public interface Button extends UIComponent {}

    public interface Checkbox extends UIComponent {}

    public interface ProgressBar extends UIComponent {}

    public static class SimpleTitle implements Title {
        private final String style;
        private final String text;

        public SimpleTitle(String style, String text) {
            this.style = style;
            this.text = text;
        }

        @Override
        public String paint() {
            return style + " Title: " + text;
        }
    }

    public static class WinLightButton implements Button {
        private final String text;

        public WinLightButton(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Windows Light Button: " + text;
        }
    }

    public static class WinDarkButton implements Button {
        private final String text;

        public WinDarkButton(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Windows Dark Button: " + text;
        }
    }

    public static class MacLightButton implements Button {
        private final String text;

        public MacLightButton(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Mac Light Button: " + text;
        }
    }

    public static class MacDarkButton implements Button {
        private final String text;

        public MacDarkButton(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Mac Dark Button: " + text;
        }
    }

    public static class LinuxLightButton implements Button {
        private final String text;

        public LinuxLightButton(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Linux Light Button: " + text;
        }
    }

    public static class LinuxDarkButton implements Button {
        private final String text;

        public LinuxDarkButton(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Linux Dark Button: " + text;
        }
    }

    public static class WinLightCheckbox implements Checkbox {
        private final String text;

        public WinLightCheckbox(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Windows Light Checkbox: " + text;
        }
    }

    public static class WinDarkCheckbox implements Checkbox {
        private final String text;

        public WinDarkCheckbox(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Windows Dark Checkbox: " + text;
        }
    }

    public static class MacLightCheckbox implements Checkbox {
        private final String text;

        public MacLightCheckbox(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Mac Light Checkbox: " + text;
        }
    }

    public static class MacDarkCheckbox implements Checkbox {
        private final String text;

        public MacDarkCheckbox(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Mac Dark Checkbox: " + text;
        }
    }

    public static class LinuxLightCheckbox implements Checkbox {
        private final String text;

        public LinuxLightCheckbox(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Linux Light Checkbox: " + text;
        }
    }

    public static class LinuxDarkCheckbox implements Checkbox {
        private final String text;

        public LinuxDarkCheckbox(String text) {
            this.text = text;
        }

        @Override
        public String paint() {
            return "Linux Dark Checkbox: " + text;
        }
    }

    public static class WinLightProgressBar implements ProgressBar {
        private final int value;

        public WinLightProgressBar(int value) {
            this.value = value;
        }

        @Override
        public String paint() {
            return "Windows Light ProgressBar: " + value + "%";
        }
    }

    public static class WinDarkProgressBar implements ProgressBar {
        private final int value;

        public WinDarkProgressBar(int value) {
            this.value = value;
        }

        @Override
        public String paint() {
            return "Windows Dark ProgressBar: " + value + "%";
        }
    }

    public static class MacLightProgressBar implements ProgressBar {
        private final int value;

        public MacLightProgressBar(int value) {
            this.value = value;
        }

        @Override
        public String paint() {
            return "Mac Light ProgressBar: " + value + "%";
        }
    }

    public static class MacDarkProgressBar implements ProgressBar {
        private final int value;

        public MacDarkProgressBar(int value) {
            this.value = value;
        }

        @Override
        public String paint() {
            return "Mac Dark ProgressBar: " + value + "%";
        }
    }

    public static class LinuxLightProgressBar implements ProgressBar {
        private final int value;

        public LinuxLightProgressBar(int value) {
            this.value = value;
        }

        @Override
        public String paint() {
            return "Linux Light ProgressBar: " + value + "%";
        }
    }

    public static class LinuxDarkProgressBar implements ProgressBar {
        private final int value;

        public LinuxDarkProgressBar(int value) {
            this.value = value;
        }

        @Override
        public String paint() {
            return "Linux Dark ProgressBar: " + value + "%";
        }
    }
}
