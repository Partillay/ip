package partillay.ui;

import partillay.command.Command;
import partillay.exception.PartillayException;
import partillay.parser.Parser;
import partillay.storage.Storage;
import partillay.task.TaskList;

/**
 * Main class of the whole programme to run the chatbot.
 */
public class Partillay {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a new Partillay object to run the programme,
     * possess less significance.
     */
    public Partillay() {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.getTasks());
    }

    /**
     * Runs the chatbot, and calls relevant objects like ui
     * to give output
     */
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

    /**
     * The entry point of application.
     *
     * @param args the input arguments that are ignored upon execution
     */
    public static void main(String[] args) {
        new Partillay().run();
    }
}
