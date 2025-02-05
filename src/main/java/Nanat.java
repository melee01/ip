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

        System.out.println("Good Morning! I'm\n" + logo + "\nWhat brings you here today?");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) {
                System.out.println("     Bye. Have a great day!");
                System.out.println("____________________________________________________________");
                break;
            } else {
                System.out.println("     " + command);
            }
        }
        scanner.close();
    }
}
