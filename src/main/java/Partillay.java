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
                for (int i = 0; i < taskIndex; i++) {
                    System.out.println(i + 1 + "." + tasks[i].getTaskStatus());
                }
                System.out.println(HORIZONTAL_LINE);
                continue;

            }

            if (userInput.startsWith("mark")) {
                System.out.println("Nice! I've marked this task as done:");
                int taskIndexToMark = Integer.parseInt(userInput.substring(5));
                tasks[taskIndexToMark - 1].mark();
                System.out.println(tasks[taskIndexToMark - 1].getTaskStatus());
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            if (userInput.startsWith("unmark")) {
                System.out.println("OK, I've marked this task as not done yet:");
                int taskIndexToUnmark = Integer.parseInt(userInput.substring(7));
                tasks[taskIndexToUnmark - 1].unmark();
                System.out.println(tasks[taskIndexToUnmark - 1].getTaskStatus());
                System.out.println(HORIZONTAL_LINE);
                continue;
            }

            System.out.println("added: " + userInput);
            tasks[taskIndex] = new Task(userInput);
            taskIndex++;
            System.out.println(HORIZONTAL_LINE);

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

    public String getTaskStatus() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void mark() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

}


