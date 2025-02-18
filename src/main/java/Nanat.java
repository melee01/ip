import java.util.ArrayList;
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

        // Start the user command loop
        startCommandLoop();
    }

    /**
     * Starts the loop to handle user commands.
     */
    public static void startCommandLoop() {
        // Initialize the task list and scanner
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        // Main loop to handle user commands
        while (true) {
            String command = scanner.nextLine();
            Parser.handleCommand(command, taskList);
        }
    }
}
