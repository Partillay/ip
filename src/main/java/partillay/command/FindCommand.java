package partillay.command;

import partillay.task.Task;
import partillay.task.TaskList;
import partillay.ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String toBeSearched;

    public FindCommand(String text) {
        this.toBeSearched = text;
    }

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
