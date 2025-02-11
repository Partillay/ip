package ui;

import java.util.ArrayList;

import task.Task;

public class Ui {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";

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
        System.out.println("Error: " + message);
        showLine();
    }

    public void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public void showTaskList(ArrayList<Task> tasks) {
        showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        showLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}