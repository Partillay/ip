import command.*;

import parser.Parser;

import storage.Storage;

import task.*;

import ui.Ui;

import exception.*;

public class Partillay {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Partillay() {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.getTasks());
    }

    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui);
                isExit = c.getExitPermission();
            } catch (PartillayException e) {
                ui.showError(e.getMessage());
            } finally {
                storage.writeTasksToFile(tasks);
            }
        }

    }

    public static void main(String[] args) {
        new Partillay().run();
    }
}