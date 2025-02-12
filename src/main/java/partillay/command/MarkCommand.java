package partillay.command;

import partillay.exception.PartillayIndexException;

import partillay.task.TaskList;

import partillay.ui.Ui;

public class MarkCommand extends Command {
    private final int taskIndexToMark;

    public MarkCommand(int i) {
        this.taskIndexToMark = i;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws PartillayIndexException {
        try {
            if (taskIndexToMark > tasks.size()) {
                throw new PartillayIndexException("No such index in your task list, bestie!");
            }
            ui.showLine();
            ui.showMessage("Nice! I've marked this task as done:");
            tasks.markTask(taskIndexToMark - 1);
            ui.showMessage(tasks.getTaskAsString(taskIndexToMark - 1));
            ui.showLine();
        } catch (PartillayIndexException e) {
            ui.showError(e.getMessage());
        }
    }
}