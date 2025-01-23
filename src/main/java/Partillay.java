import java.util.Scanner;

public class Partillay {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";

    public static void main(String[] args) {

        String[] tasks = new String[100];
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
                    System.out.println(i + 1 + ". " + tasks[i]);
                }
                System.out.println(HORIZONTAL_LINE);
                continue;

            }

            System.out.println("added: " + userInput);
            tasks[taskIndex] = userInput;
            taskIndex++;
            System.out.println(HORIZONTAL_LINE);

        }

        sc.close();

    }

}

