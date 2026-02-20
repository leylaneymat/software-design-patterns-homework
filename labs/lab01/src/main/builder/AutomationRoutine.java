package builder;
import abstractfactory.SmartDevice;
import java.util.List;

public class AutomationRoutine {
    private final String name;
    private final List<SmartDevice> devices;
    private final String triggerTime;
    private final boolean sendNotification;

    public AutomationRoutine(String name, List<SmartDevice> devices, String triggerTime, boolean sendNotification) {
        this.name = name;
        this.devices = devices;
        this.triggerTime = triggerTime;
        this.sendNotification = sendNotification;
    }

    public String getName() {
        return name;
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }

    public String getTriggerTime() {
        return triggerTime;
    }

    public boolean isSendNotification() {
        return sendNotification;
    }

    @Override
    public String toString() {
        return "AutomationRoutine{" +
                "name='" + name + '\'' +
                ", devicesCount=" + devices.size() +
                ", triggerTime='" + triggerTime + '\'' +
                ", sendNotification=" + sendNotification +
                '}';
    }
}
