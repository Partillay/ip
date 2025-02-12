package partillay.command;

import partillay.task.TaskList;

import partillay.ui.Ui;

public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, Ui ui);

    public boolean getExitPermission() {
        return isExit;
    }
}