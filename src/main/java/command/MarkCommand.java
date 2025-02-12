package command;

import java.util.ArrayList;

import task.Task;

import ui.Ui;

public class MarkCommand extends Command {
    private final int taskIndexToMark;

    public MarkCommand(int i) {
        taskIndexToMark = i;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui) {
        ui.showLine();
        ui.showMessage("Nice! I've marked this task as done:");
        tasks.get(taskIndexToMark - 1).mark();
        ui.showMessage(tasks.get(taskIndexToMark - 1).toString());
        ui.showLine();
    }
}