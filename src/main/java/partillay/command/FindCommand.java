package partillay.command;

import java.util.ArrayList;

import partillay.task.Task;
import partillay.task.TaskList;
import partillay.ui.Ui;

/**
 * Represents a find command to find tasks in a task list.
 */
public class FindCommand extends Command {
    private final String toBeSearched;

    /**
     * Constructs a new Find command.
     *
     * @param text the keyword to search in the task list
     */
    public FindCommand(String text) {
        this.toBeSearched = text;
    }

    /**
     * Iterates through the tasks in task list and displays tasks containing the keyword.
     *
     * @param tasks the task list that stores current tasks
     * @param ui    the user interface for displaying output
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showLine();
        ui.showMessage("Here are the matching tasks in your list:");
        ArrayList<Task> tasksToShow = tasks.getTasks();
        int showIndex = 1;
        for (Task task : tasksToShow) {
            if (task.getDescription().contains(toBeSearched)) {
                ui.showMessage(showIndex + ". " + task.toString());
                showIndex++;
            }
        }
        ui.showLine();
    }
}
