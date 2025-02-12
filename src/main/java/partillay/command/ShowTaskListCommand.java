package partillay.command;

import partillay.task.TaskList;

import partillay.ui.Ui;

public class ShowTaskListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showTaskList(tasks);
    }
}
