package partillay.command;

import partillay.exception.PartillayIndexException;

import partillay.task.TaskList;

import partillay.ui.Ui;

/**
 * Represents an unmark command that unmarks a task.
 */
public class UnmarkCommand extends Command {
    private final int taskIndexToUnmark;

    /**
     * Constructs a new Unmark command.
     *
     * @param index the index of the task to be unmarked
     */
    public UnmarkCommand(int index) {
        this.taskIndexToUnmark = index;
    }

    /**
     * Marks task in task list with given task index and displays the updated task list.
     *
     * @param tasks the task list that stores current tasks
     * @param ui    the user interface for displaying output
     * @throws PartillayIndexException if index > number of tasks or index <= 0
     */
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