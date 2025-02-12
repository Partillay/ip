package command;

import java.util.ArrayList;
import task.Task;
import ui.Ui;

public abstract class Command {
    public abstract void execute(ArrayList<Task> tasks, Ui ui);
}