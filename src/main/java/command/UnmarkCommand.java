package command;

import exception.PartillayIndexException;

import task.TaskList;

import ui.Ui;

public class UnmarkCommand extends Command {
    private final int taskIndexToUnmark;

    public UnmarkCommand(int i) {
        this.taskIndexToUnmark = i;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws PartillayIndexException {
        try {
            if (taskIndexToUnmark > tasks.size()) {
                throw new PartillayIndexException("No such index in your task list, bestie!");
            }
            ui.showLine();
            ui.showMessage("OK, I've marked this task as not done yet:");
            tasks.unmarkTask(taskIndexToUnmark - 1);
            ui.showMessage(tasks.getTaskAsString(taskIndexToUnmark - 1));
            ui.showLine();
        } catch (PartillayIndexException e) {
            ui.showError(e.getMessage());
        }
    }
}