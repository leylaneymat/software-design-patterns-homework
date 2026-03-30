package omnihome;

import java.util.HashMap;
import java.util.Map;

import omnihome.command.ArmAlarmCommand;
import omnihome.command.SmartRemote;
import omnihome.command.TurnOnLightCommand;
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
