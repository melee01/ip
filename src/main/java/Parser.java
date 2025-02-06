import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parses and handles user commands.
 */
public class Parser {

    /**
     * Handles user input and processes task-related commands.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store tasks.
     */
    public static void handleCommand(String command, TaskList taskList) {
        if (command.startsWith("todo ")) {
            handleTodo(command, taskList);
        } else if (command.startsWith("deadline ")) {
            handleDeadline(command, taskList);
        } else if (command.startsWith("event ")) {
            handleEvent(command, taskList);
        } else if (command.equals("bye")) {
            Ui.showGoodbyeMessage();
            System.exit(0);
        }
    }

    /**
     * Handles the creation of a ToDo task.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store the task.
     */
    private static void handleTodo(String command, TaskList taskList) {
        String description = command.substring(5).trim();
        if (description.isEmpty()) {
            ErrorHandler.handleEmptyDescription();
        }
        //taskList.addTask(description);
        int num = taskList.numOfTasks();
        Ui.showAddedMessage(1, description, num);
    }

    /**
     * Handles the creation of a Deadline task.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store the task.
     */
    private static void handleDeadline(String command, TaskList taskList) {
        String description = command.substring(9).trim();
        String[] parts = description.split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            ErrorHandler.handleEmptyDeadline();
        }
        //taskList.addTask(description);
        int num = taskList.numOfTasks();
        Ui.showAddedMessage(2, description, num);
    }

    /**
     * Handles the creation of an Event task.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store the task.
     */
    private static void handleEvent(String command, TaskList taskList) {
        String description = command.substring(6).trim();

        String[] parts = description.split(" /from ", 2);
        String[] timeParts = parts[1].split(" /to ", 2);

        if (parts.length < 2 || !parts[1].contains(" /to ") || parts[0].trim().isEmpty() || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
            ErrorHandler.handleEmptyEvent();
        }

        //taskList.addTask(event);
        int num = taskList.numOfTasks();
        Ui.showAddedMessage(3, description, num);
    }
}