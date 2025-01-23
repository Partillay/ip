import java.util.Scanner;

public class Partillay {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";

    public static void main(String[] args) {

        Task[] tasks = new Task[100];
        int taskIndex = 0;

        System.out.println(HORIZONTAL_LINE);
        System.out.println("Hello! I'm Partillay, your ABSOLUTELY greatest bestie.");
        System.out.println("Anything I CAN HELP?");
        System.out.println(HORIZONTAL_LINE);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String userInput = sc.nextLine();
            System.out.println(HORIZONTAL_LINE);

            if (userInput.equals("bye")) {
                System.out.println("Bye. See you later! Slay!");
                System.out.println(HORIZONTAL_LINE);
                break;
            }

            if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskIndex; i++) {
                    System.out.println(i + 1 + "." + tasks[i]);
                }
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            if (userInput.startsWith("mark")) {
                System.out.println("Nice! I've marked this task as done:");
                int taskIndexToMark = Integer.parseInt(userInput.substring(5));
                tasks[taskIndexToMark - 1].mark();
                System.out.println(tasks[taskIndexToMark - 1]);
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            if (userInput.startsWith("unmark")) {
                System.out.println("OK, I've marked this task as not done yet:");
                int taskIndexToUnmark = Integer.parseInt(userInput.substring(7));
                tasks[taskIndexToUnmark - 1].unmark();
                System.out.println(tasks[taskIndexToUnmark - 1]);
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            if (userInput.startsWith("todo")) {
                String description = userInput.substring(5);
                tasks[taskIndex] = new ToDo(description);
                taskIndex++;
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskIndex - 1]);
                System.out.println("Now you have " + taskIndex + " tasks in the list.");
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            if (userInput.startsWith("deadline")) {
                String[] parts = userInput.substring(9).split(" /by ");
                String description = parts[0].trim();
                String by = parts[1].trim();
                tasks[taskIndex] = new Deadline(description, by);
                taskIndex++;
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskIndex - 1]);
                System.out.println("Now you have " + taskIndex + " tasks in the list.");
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            if (userInput.startsWith("event")) {
                String[] parts = userInput.substring(6).split(" /from | /to ");
                String description = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                tasks[taskIndex] = new Event(description, from, to);
                taskIndex++;
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskIndex - 1]);
                System.out.println("Now you have " + taskIndex + " tasks in the list.");
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
