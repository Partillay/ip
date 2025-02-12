package partillay.ui;

import java.util.ArrayList;
import java.util.Scanner;

import partillay.task.Task;
import partillay.task.TaskList;

public class Ui {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";
    private final Scanner scanner = new Scanner(System.in);

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showWelcomeMessage() {
        showLine();
        System.out.println("Hello! I'm Partillay, your ABSOLUTELY greatest bestie.");
        System.out.println("Anything I CAN HELP?");
        showLine();
    }

    public void showGoodbyeMessage() {
        showLine();
        System.out.println("Bye. See you later! Slay!");
        showLine();
    }

    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    public void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public void showTaskList(TaskList tasks) {
        showLine();
        System.out.println("Here are the tasks in your list:");
        ArrayList<Task> tasksToShow = tasks.getTasks();
        for (int i = 0; i < tasksToShow.size(); i++) {
            showMessage((i + 1) + ". " + tasksToShow.get(i));
        }
        showLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}