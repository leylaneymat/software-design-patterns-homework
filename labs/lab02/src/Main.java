package omnihome;

import java.util.HashMap;
import java.util.Map;

import omnihome.devices.SmartAlarm;
import omnihome.devices.SmartLights;
import omnihome.observer.MotionSensor;
import omnihome.strategy.AlertStrategy;
import omnihome.strategy.LoudSirenStrategy;
import omnihome.strategy.SilentPushStrategy;

public class Main {
    public static void main(String[] args) {
        Map<String, AlertStrategy> alertRegistry = new HashMap<>();
        alertRegistry.put("SILENT", new SilentPushStrategy());
        alertRegistry.put("SIREN", new LoudSirenStrategy());

        MotionSensor motionSensor = new MotionSensor();
        SmartLights smartLights = new SmartLights();
        SmartAlarm smartAlarm = new SmartAlarm(alertRegistry);

        System.out.println("Event Bus & Strategy Demo");
        smartAlarm.setAlertStrategy("SILENT");
        smartAlarm.arm();
        motionSensor.addObserver(smartLights);
        motionSensor.addObserver(smartAlarm);

        motionSensor.detectMotion();
    }
}
