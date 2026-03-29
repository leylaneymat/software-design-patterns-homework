package omnihome.command;

import java.util.ArrayList;
import java.util.List;

public class SmartRemote {
    private final List<Command> slots;
    private Command lastCommand;

    public SmartRemote(int numberOfSlots) {
        slots = new ArrayList<>(numberOfSlots);
        for (int i = 0; i < numberOfSlots; i++) {
            slots.add(null);
        }
        lastCommand = null;
    }

    public void setCommand(int slot, Command command) {
        validateSlot(slot);
        slots.set(slot, command);
    }

    public void pressButton(int slot) {
        validateSlot(slot);
        Command command = slots.get(slot);
        if (command == null) {
            System.out.println("No command assigned to this button.");
            return;
        }
        command.execute();
        lastCommand = command;
    }

    public void pressUndo() {
        if (lastCommand == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        lastCommand.undo();
        lastCommand = null;
    }
}
