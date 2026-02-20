package builder;
import abstractfactory.SmartDevice;
import java.util.ArrayList;
import java.util.List;

public class RoutineBuilder {
    private String name;
    private final List<SmartDevice> devices = new ArrayList<>();
    private String triggerTime;
    private boolean sendNotification;

    public RoutineBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RoutineBuilder addDevice(SmartDevice device) {
        this.devices.add(device);
        return this;
    }

    public RoutineBuilder atTime(String triggerTime) {
        this.triggerTime = triggerTime;
        return this;
    }

    public RoutineBuilder toggleNotification(boolean sendNotification) {
        this.sendNotification = sendNotification;
        return this;
    }

    public AutomationRoutine build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Routine name is required.");
        }
        if (devices.isEmpty()) {
            throw new IllegalStateException("At least one device is required.");
        }
        if (triggerTime == null || triggerTime.isBlank()) {
            throw new IllegalStateException("Trigger time is required.");
        }

        return new AutomationRoutine(name, new ArrayList<>(devices), triggerTime, sendNotification);
    }
}
