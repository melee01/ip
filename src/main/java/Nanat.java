import java.util.Scanner;
/**
 * The main class that runs the task management program.
 */
public class Nanat {
    /**
     * Starts the task management program, ensuring the data file exists and interacting with the user.
     *
     * @param args Command-line arguments (unused in this case).
     */
    public static void main(String[] args) {
        Ui.showWelcomeMessage();

        Save.ensureDataFileExists();

        // Create a TaskList instance and load tasks from the file if they exist
        TaskList taskList = new TaskList();
        Save.loadTasksFromFile(taskList);

        // Start the user command loop
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
