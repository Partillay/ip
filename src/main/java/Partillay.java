import java.util.ArrayList;
import java.util.Scanner;

import task.*;

import command.*;

import ui.Ui;

import exception.*;

import storage.Storage;

public class Partillay {

    public static void main(String[] args) {

        Storage storage = new Storage();

        ArrayList<Task> tasks = storage.getTasks();
        Ui ui = new Ui();

        ui.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            storage.writeTasksToFile(tasks);

            try {
                String userInput = scanner.nextLine();

                if (userInput.trim().equals("bye")) {
                    ui.showGoodbyeMessage();
                    break;
                }

                if (userInput.trim().equals("list")) {
                    ui.showTaskList(tasks);
                    continue;
                }

                // Handle an error here (index out of bounds)
                if (userInput.startsWith("mark")) {
                    int taskIndexToMark;
                    try {
                        taskIndexToMark = Integer.parseInt(userInput.substring(5));
                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    if (taskIndexToMark > tasks.size()) {
                        throw new PartillayIndexException("No such index in your task list!");
                    }

                    Command command = new MarkCommand(taskIndexToMark);
                    command.execute(tasks, ui);

                    continue;
                }

                // Handle an error here (index out of bounds)
                if (userInput.startsWith("unmark")) {
                    int taskIndexToUnmark;
                    try {
                        taskIndexToUnmark = Integer.parseInt(userInput.substring(5));
                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    if (taskIndexToUnmark > tasks.size()) {
                        throw new PartillayIndexException("No such index in your task list!");
                    }

                    Command command = new UnmarkCommand(taskIndexToUnmark);
                    command.execute(tasks, ui);

                    continue;
                }

                if (userInput.startsWith("delete")) {
                    int taskIndexToDelete;
                    try {
                        taskIndexToDelete = Integer.parseInt(userInput.substring(7));
                    } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    if (taskIndexToDelete > tasks.size()) {
                        throw new PartillayIndexException("No such index in your task list!");
                    }

                    Command command = new DeleteCommand(taskIndexToDelete - 1);
                    command.execute(tasks, ui);

                    continue;
                }

                if (userInput.startsWith("todo")) {
                    String description = userInput.substring(4);
                    if (!description.startsWith(" ") && !description.isEmpty()) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    description = description.trim();
                    if (description.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, your task cannot be empty!");
                    }

                    Command command = new AddCommand(new ToDo(description));
                    command.execute(tasks, ui);

                    continue;
                }

                if (userInput.startsWith("deadline")) {
                    String input = userInput.substring(8);
                    if (!input.startsWith(" ") && !input.isEmpty()) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    input = input.trim();
                    if (input.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, your task cannot be empty!");
                    }
                    String[] parts = userInput.substring(9).split(" /by ");
                    if (parts.length != 2) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    String description = parts[0].trim();
                    String by = parts[1].trim();
                    if (description.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, your task cannot be empty!");
                    }
                    if (by.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, I need your deadline!");
                    }

                    Command command = new AddCommand(new Deadline(description, by));
                    command.execute(tasks, ui);

                    continue;
                }

                if (userInput.startsWith("event")) {
                    String input = userInput.substring(5);
                    if (!input.startsWith(" ") && !input.isEmpty()) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    input = input.trim();
                    if (input.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, your task cannot be empty!");
                    }
                    String[] parts = userInput.substring(6).split(" /from | /to ");
                    if (parts.length != 3) {
                        throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                    }
                    String description = parts[0].trim();
                    String from = parts[1].trim();
                    String to = parts[2].trim();
                    if (description.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, your task cannot be empty!");
                    }
                    if (from.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, I need your starting time!");
                    }
                    if (to.isEmpty()) {
                        throw new PartillayIncompleteDescriptionException("Bestie, I need your ending time!");
                    }

                    Command command = new AddCommand(new Event(description, from, to));
                    command.execute(tasks, ui);

                } else {
                    throw new PartillayInvalidCommandException("That's not a valid command, bestie!");
                }

            } catch (PartillayException e) {
                ui.showError(e.getMessage());
            }
        }

        scanner.close();

    }

}