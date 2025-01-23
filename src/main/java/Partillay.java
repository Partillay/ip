import java.util.Scanner;

public class Partillay {
    private static final String HORIZONTAL_LINE = "____________________________________________________________";

    public static void main(String[] args) {

        System.out.println(HORIZONTAL_LINE);
        System.out.println("Hello! I'm Partillay, your ABSOLUTELY greatest bestie.");
        System.out.println("Anything I CAN HELP?");
        System.out.println(HORIZONTAL_LINE);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                System.out.println(HORIZONTAL_LINE);
                System.out.println("Bye. See you later! Slay!");
                System.out.println(HORIZONTAL_LINE);
                break;
            }

            System.out.println(HORIZONTAL_LINE);
            System.out.println("I got it! You said " + userInput);
            System.out.println(HORIZONTAL_LINE);

        }

        sc.close();

    }

}

