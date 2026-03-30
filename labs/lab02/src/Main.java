import java.util.HashMap;
import java.util.Map;

import command.ArmAlarmCommand;
import command.SmartRemote;
import command.TurnOnLightCommand;
import devices.SmartAlarm;
import devices.SmartLights;
import observer.MotionSensor;
import strategy.AlertStrategy;
import strategy.LoudSirenStrategy;
import strategy.SilentPushStrategy;

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

        smartAlarm.setAlertStrategy("SIREN");
        motionSensor.detectMotion();

        System.out.println();
        System.out.println("Smart Remote & Command Demo");
        SmartRemote remote = new SmartRemote(2);
        remote.setCommand(0, new TurnOnLightCommand(smartLights));
        remote.setCommand(1, new ArmAlarmCommand(smartAlarm));

        smartAlarm.disarm();
        remote.pressButton(0);
        remote.pressButton(1);
        remote.pressUndo();
    }
}
