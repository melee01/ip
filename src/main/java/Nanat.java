import java.util.Scanner;

/**
 * The main class that runs the task management program, interacting with the user.
 */
public class Nanat {

    /**
     * Starts the task management program, interacting with the user via command input.
     *
     * @param args Command-line arguments (unused in this case).
     */
    public static void main(String[] args) {
        Ui.showWelcomeMessage();

        // Create a single TaskList instance and start the user command loop
        TaskList taskList = new TaskList();
        startCommandLoop(taskList);
    }

    /**
     * Starts the loop to handle user commands.
     *
     * @param taskList The TaskList instance to store tasks.
     */
    public static void startCommandLoop(TaskList taskList) {
        Scanner scanner = new Scanner(System.in);

        // Main loop to handle user commands
        while (true) {
            String command = scanner.nextLine();
            Parser.handleCommand(command, taskList);
        }
    }
}
