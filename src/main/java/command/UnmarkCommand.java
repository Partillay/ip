package command;

import java.util.ArrayList;

import task.Task;

import ui.Ui;

public class UnmarkCommand extends Command {
    private final int taskIndexToUnmark;

    public UnmarkCommand(int i) {
        taskIndexToUnmark = i;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui) {
        ui.showLine();
        ui.showMessage("OK, I've marked this task as not done yet:");
        tasks.get(taskIndexToUnmark - 1).unmark();
        ui.showMessage(tasks.get(taskIndexToUnmark - 1).toString());
        ui.showLine();
    }
}