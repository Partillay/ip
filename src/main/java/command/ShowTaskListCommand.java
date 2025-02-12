package command;

import task.TaskList;

import ui.Ui;

public class ShowTaskListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showTaskList(tasks);
    }
}
