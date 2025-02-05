import java.util.Scanner;

public class Nanat {
    public static void main(String[] args) {
        String logo = """
                __  __            __  __            _______
                | \\ | |    / \\    | \\ | |     / \\   |_   _|
                |  \\| |   / _ \\   |  \\| |    / _ \\    | |
                | . ` |  / ___ \\  | . ` |   / ___ \\   | |
                |_|\\ _| /_/   \\_\\ |_|\\ _|  /_/   \\_\\  |_|
                """;

        System.out.println("____________________________________________________________");
        System.out.println("Good Morning! I'm\n" + logo + "\nWhat brings you here today?");
        System.out.println("____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[100];  // Fixed-size array for storage
        int count = 0;  // Tracks the number of stored tasks

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("     Bye. Have a great day!");
                System.out.println("____________________________________________________________");
                break;
            } else if (command.equals("list")) {
                System.out.println("____________________________________________________________");
                if (count == 0) {
                    System.out.println("     No tasks found.");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println("     " + (i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else {
                if (count < 100) {
                    tasks[count++] = command;  // Store the task
                    System.out.println("____________________________________________________________");
                    System.out.println("     added: " + command);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("     Storage limit reached. Cannot add more tasks.");
                    System.out.println("____________________________________________________________");
                }
            }
        }
        scanner.close();
    }
}
