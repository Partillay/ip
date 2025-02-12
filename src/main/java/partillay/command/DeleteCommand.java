package partillay.command;

import partillay.exception.PartillayIndexException;

import partillay.task.Task;
import partillay.task.TaskList;

import partillay.ui.Ui;

public class DeleteCommand extends Command {
    private final int taskIndexToDelete;

    public DeleteCommand(int index) {
        this.taskIndexToDelete = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws PartillayIndexException {
        try {
            if (taskIndexToDelete > tasks.size()) {
                this.isExit = true;
                throw new PartillayIndexException("No such index in your task list, bestie!");
            }
            ui.showLine();
            Task removedTask = tasks.deleteTask(taskIndexToDelete - 1);
            ui.showMessage("Noted. I've removed this task:");
            ui.showMessage(removedTask.toString());
            ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
            ui.showLine();
        } catch (PartillayIndexException e) {
            ui.showError(e.getMessage());
        }

    }
}