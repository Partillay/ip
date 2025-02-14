package partillay.ui;

import java.util.ArrayList;
import java.util.Scanner;

import partillay.task.Task;
import partillay.task.TaskList;

/**
 * Represents the user interface (UI) that handles input and output interactions with the user.
 */
public class Ui {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads the next line of input from the user.
     *
     * @return the command entered by the user
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a welcome message to the user when the program starts.
     */
    public void showWelcomeMessage() {
        showLine();
        System.out.println("Hello! I'm Partillay, your ABSOLUTELY greatest bestie.");
        System.out.println("Anything I CAN HELP?");
        showLine();
    }

    /**
     * Displays a goodbye message to the user when the program ends.
     */
    public void showGoodbyeMessage() {
        showLine();
        System.out.println("Bye. See you later! Slay!");
        showLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to be displayed
     */
    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    /**
     * Prints a horizontal line to the console for separation between outputs.
     */
    public void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Displays the list of tasks to the user.
     *
     * @param tasks the TaskList containing the tasks to be displayed
     */
    public void showTaskList(TaskList tasks) {
        showLine();
        System.out.println("Here are the tasks in your list:");
        ArrayList<Task> tasksToShow = tasks.getTasks();
        for (int i = 0; i < tasksToShow.size(); i++) {
            showMessage((i + 1) + ". " + tasksToShow.get(i));
        }
        showLine();
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to be displayed
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}