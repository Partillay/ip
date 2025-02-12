package command;

import task.TaskList;

import ui.Ui;

public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, Ui ui);

    public boolean getExitPermission() {
        return isExit;
    }
}