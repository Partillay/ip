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
    public String execute(TaskList tasks, Ui ui) {
        String result = "Here are the matching tasks in your list:\n";
        ArrayList<Task> tasksToShow = tasks.getTasks();
        int showIndex = 1;
        for (Task task : tasksToShow) {
            if (task.getDescription().contains(toBeSearched)) {
                result += showIndex + ". " + task.toString() + "\n";
                showIndex++;
            }
        }
        return ui.getLinedMessage(result);
    }
}
