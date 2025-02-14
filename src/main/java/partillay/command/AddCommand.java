package partillay.command;

import partillay.task.TaskList;
import partillay.task.Task;

import partillay.ui.Ui;

/**
 * Represents a command that adds a task to the task list.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs a new Add command with the specific task.
     *
     * @param task the task to be added to task list
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Adds the task to the task list and displays the updated task list.
     *
     * @param tasks the task list that stores current tasks
     * @param ui    the user interface for displaying output
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showLine();
        tasks.addTask(task);
        ui.showMessage("Got it. I've added this task:");
        ui.showMessage(task.toString());
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        ui.showLine();
    }

    /**
     * Returns equality between the current instance and another object.
     *
     * @param other the object to be compared
     * @return {@code true} if both {@code AddCommand} instances have the same task to be added, otherwise {@code false}
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AddCommand otherCommand) {
            return task.equals(otherCommand.task);
        }
        return false;
    }
}