import abstractfactory.DeviceFactory;
import abstractfactory.LuxuryFactory;
import abstractfactory.SmartLight;
import abstractfactory.SmartLock;
import abstractfactory.SmartThermostat;
import adapter.GlorbAdapter;
import adapter.GlorbThermostat;
import builder.AutomationRoutine;
import builder.RoutineBuilder;
import prototype.Configuration;
import singleton.CloudConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1 - Singleton");
        CloudConnection firstConnection = CloudConnection.getInstance("API-123", "https://cloud.omnihome.com");
        CloudConnection secondConnection = CloudConnection.getInstance("API-456", "https://other-server.com");
        firstConnection.connect();
        System.out.println("First instance reference: " + firstConnection);
        System.out.println("Second instance reference: " + secondConnection);

        System.out.println("\nTask 2 - Abstract Factory");
        DeviceFactory factory = new LuxuryFactory();
        SmartLight light = factory.createLight();
        SmartLock lock = factory.createLock();
        SmartThermostat thermostat = factory.createThermostat();
        light.turnOn();
        lock.lock();
        thermostat.setTemperature(22.5);

        System.out.println("\nTask 3 - Adapter");
        GlorbThermostat legacyThermostat = new GlorbThermostat();
        SmartThermostat adaptedThermostat = new GlorbAdapter(legacyThermostat);
        adaptedThermostat.setTemperature(25.0);

        System.out.println("\nTask 4 - Builder");
        AutomationRoutine movieNight = new RoutineBuilder()
                .withName("Movie Night")
                .addDevice(light)
                .addDevice(lock)
                .addDevice(thermostat)
                .addDevice(adaptedThermostat)
                .atTime("21:00")
                .toggleNotification(true)
                .build();
        AutomationRoutine vacationMode = new RoutineBuilder()
                .withName("Vacation Mode")
                .addDevice(light)
                .addDevice(lock)
                .addDevice(thermostat)
                .addDevice(adaptedThermostat)
                .atTime("08:00")
                .toggleNotification(true)
                .build();
        System.out.println(movieNight);
        System.out.println(vacationMode);

        System.out.println("\nTask 5 - Prototype");
        Configuration livingRoomConfig = new Configuration("192.168.1.10", 8080, "v1.4.0");
        Configuration guestRoomConfig = livingRoomConfig.clone();
        guestRoomConfig.setIpAddress("192.168.1.22");

        System.out.println("Original config IP (Living Room): " + livingRoomConfig.getIpAddress());
        System.out.println("Cloned config IP (Guest Room): " + guestRoomConfig.getIpAddress());
    }
}
