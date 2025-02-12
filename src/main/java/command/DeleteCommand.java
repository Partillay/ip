package command;

import java.util.ArrayList;

import task.Task;

import ui.Ui;

public class DeleteCommand extends Command {
    private final int toDeleteIndex;

    public DeleteCommand(int index) {
        this.toDeleteIndex = index;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui) {
        ui.showLine();
        Task removedTask = tasks.remove(toDeleteIndex);
        ui.showMessage("Noted. I've removed this task:");
        ui.showMessage(removedTask.toString());
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        ui.showLine();
    }
}