package partillay.command;

import partillay.task.TaskList;
import partillay.task.Task;

import partillay.ui.Ui;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showLine();
        tasks.addTask(task);
        ui.showMessage("Got it. I've added this task:");
        ui.showMessage(task.toString());
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        ui.showLine();
    }
}