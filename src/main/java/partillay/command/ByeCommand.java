package partillay.command;

import partillay.task.TaskList;

import partillay.ui.Ui;

public class ByeCommand extends Command {
    public ByeCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.showGoodbyeMessage();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other instanceof ByeCommand;
    }
}
