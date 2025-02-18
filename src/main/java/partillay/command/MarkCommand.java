package partillay.command;

import partillay.exception.PartillayIndexException;
import partillay.task.TaskList;
import partillay.ui.Ui;

/**
 * Represents a mark command that marks a task.
 */
public class MarkCommand extends Command {
    private final int taskIndexToMark;

    /**
     * Constructs a new Mark command.
     *
     * @param index the index of the task to be marked
     */
    public MarkCommand(int index) {
        this.taskIndexToMark = index;
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
            if (taskIndexToMark > tasks.size() || taskIndexToMark <= 0) {
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

    /**
     * Checks if this {@code MarkCommand} is equal to another object.
     *
     * @param other the object to be compared
     * @return {@code true} if both {@code MarkCommand} instances have the same task (index) to be marked,
     *      otherwise {@code false}
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MarkCommand) {
            return taskIndexToMark == ((MarkCommand) other).taskIndexToMark;
        }
        return false;
    }
}
