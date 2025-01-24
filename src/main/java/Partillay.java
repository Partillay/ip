import java.util.ArrayList;
import java.util.Scanner;

public class Partillay {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println(HORIZONTAL_LINE);
        System.out.println("Hello! I'm Partillay, your ABSOLUTELY greatest bestie.");
        System.out.println("Anything I CAN HELP?");
        System.out.println(HORIZONTAL_LINE);

        Scanner sc = new Scanner(System.in);

        while (true) {

            try {
                String userInput = sc.nextLine();
                System.out.println(HORIZONTAL_LINE);

                if (userInput.equals("bye")) {
                    System.out.println("Bye. See you later! Slay!");
                    System.out.println(HORIZONTAL_LINE);
                    break;
                }

                if (userInput.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + 1 + "." + tasks.get(i));
                    }
                    System.out.println(HORIZONTAL_LINE);
                    continue;
                }

                // Handle an error here (index out of bounds)
                if (userInput.startsWith("mark")) {
                    int taskIndexToMark = Integer.parseInt(userInput.substring(5));
                    if (taskIndexToMark > tasks.size()) {
                        throw new PartillayException("No such index in your task list!");
                    }
                    System.out.println("Nice! I've marked this task as done:");
                    tasks.get(taskIndexToMark - 1).mark();
                    System.out.println(tasks.get(taskIndexToMark - 1));
                    System.out.println(HORIZONTAL_LINE);
                    continue;
                }

                // Handle an error here (index out of bounds)
                if (userInput.startsWith("unmark")) {
                    int taskIndexToUnmark = Integer.parseInt(userInput.substring(7));
                    if (taskIndexToUnmark > tasks.size()) {
                        throw new PartillayException("No such index in your task list!");
                    }
                    System.out.println("OK, I've marked this task as not done yet:");
                    tasks.get(taskIndexToUnmark - 1).unmark();
                    System.out.println(tasks.get(taskIndexToUnmark - 1));
                    System.out.println(HORIZONTAL_LINE);
                    continue;
                }

                if (userInput.startsWith("delete")) {
                    int taskIndexToDelete = Integer.parseInt(userInput.substring(7));
                    if (taskIndexToDelete > tasks.size()) {
                        throw new PartillayException("No such index in your task list!");
                    }
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(tasks.get(taskIndexToDelete - 1));
                    tasks.remove(taskIndexToDelete - 1);
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println(HORIZONTAL_LINE);
                    continue;
                }

                if (userInput.startsWith("todo")) {
                    String description = userInput.substring(4);
                    if (!description.startsWith(" ") && !description.isEmpty()) {
                        throw new PartillayException("That's not a valid command, bestie!");
                    }
                    description = description.trim();
                    if (description.isEmpty()) {
                        throw new PartillayException("Bestie, your task cannot be empty!");
                    }
                    tasks.add(new ToDo(description));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(tasks.size() - 1));
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println(HORIZONTAL_LINE);
                    continue;
                }

                if (userInput.startsWith("deadline")) {
                    String input = userInput.substring(8);
                    if (!input.startsWith(" ") && !input.isEmpty()) {
                        throw new PartillayException("That's not a valid command, bestie!");
                    }
                    input = input.trim();
                    if (input.isEmpty()) {
                        throw new PartillayException("Bestie, your task cannot be empty!");
                    }
                    String[] parts = userInput.substring(9).split(" /by ");
                    if (parts.length != 2) {
                        throw new PartillayException("That's not a valid command, bestie!");
                    }
                    String description = parts[0].trim();
                    String by = parts[1].trim();
                    if (description.isEmpty()) {
                        throw new PartillayException("Bestie, your task cannot be empty!");
                    }
                    if (by.isEmpty()) {
                        throw new PartillayException("Bestie, I need your deadline!");
                    }
                    tasks.add(new Deadline(description, by));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(tasks.size() - 1));
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println(HORIZONTAL_LINE);
                    continue;
                }

                if (userInput.startsWith("event")) {
                    String input = userInput.substring(5);
                    if (!input.startsWith(" ") && !input.isEmpty()) {
                        throw new PartillayException("That's not a valid command, bestie!");
                    }
                    input = input.trim();
                    if (input.isEmpty()) {
                        throw new PartillayException("Bestie, your task cannot be empty!");
                    }
                    String[] parts = userInput.substring(6).split(" /from | /to ");
                    if (parts.length != 3) {
                        throw new PartillayException("That's not a valid command, bestie!");
                    }
                    String description = parts[0].trim();
                    String from = parts[1].trim();
                    String to = parts[2].trim();
                    if (description.isEmpty()) {
                        throw new PartillayException("Bestie, your task cannot be empty!");
                    }
                    if (from.isEmpty()) {
                        throw new PartillayException("Bestie, I need your starting time!");
                    }
                    if (to.isEmpty()) {
                        throw new PartillayException("Bestie, I need your ending time!");
                    }
                    tasks.add(new Event(description, from, to));
                    System.out.println("Got it. I've added this task:");
                    System.out.println(tasks.get(tasks.size() - 1));
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println(HORIZONTAL_LINE);
                }

                else {
                    throw new PartillayException("That's not a valid command, bestie!");
                }

            } catch (PartillayException e) {
                System.out.println(e.getMessage());
                System.out.println(HORIZONTAL_LINE);
            }
        }

        sc.close();

    }

}

class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void mark() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

}

class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}

class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

class PartillayException extends RuntimeException {
    public PartillayException(String message) {
        super(message);
    }
}