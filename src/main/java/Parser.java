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
        if (command.startsWith("todo")) {
            handleTodo(command, taskList);
        } else if (command.startsWith("deadline")) {
            handleDeadline(command, taskList);
        } else if (command.startsWith("event")) {
            handleEvent(command, taskList);
        } else if (command.equals("list")) {
            taskList.listTasks();
        } else if (command.startsWith("mark")) {
            try {
                int taskNumber = Integer.parseInt(command.substring(5)) - 1;
                taskList.markTask(taskNumber);
            } catch (NumberFormatException e) {
                ErrorHandler.handleNumberFormatException();
            }
        } else if (command.startsWith("unmark")) {
            try {
                int taskNumber = Integer.parseInt(command.substring(7)) - 1;
                taskList.unmarkTask(taskNumber);
            } catch (NumberFormatException e) {
                ErrorHandler.handleNumberFormatException();
            }
        } else if (command.startsWith("delete")) {
            int num = taskList.numOfTasks();
            try {
                int index = Integer.parseInt(command.substring(7)) - 1;
                taskList.deleteTask(index, num-1);
            } catch (NumberFormatException e) {
                ErrorHandler.handleNumberFormatException();
            }
        } else if (command.equals("bye")) {
            Ui.showGoodbyeMessage();
            System.exit(0);
        } else {
            System.out.println("     OOPS!!! The description of a todo cannot be empty.");
        }
    }

    /**
     * Handles the creation of a ToDo task.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store the task.
     */
    private static void handleTodo(String command, TaskList taskList) {
        String description = command.substring(4).trim();

        if (description.isEmpty()) {
            ErrorHandler.handleEmptyDescription();
            Nanat.startCommandLoop(taskList);
        }

        while(description.charAt(0) == ' ') {
            description.substring(1).trim();
        }

        int num = taskList.numOfTasks();
        Ui.showAddedMessage(1, description, num, taskList);
    }

    /**
     * Handles the creation of a Deadline task.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store the task.
     */
    private static void handleDeadline(String command, TaskList taskList) {
        String description = command.substring(8).trim();
        String[] parts = description.split(" /by ", 2);

        if (description.isEmpty() || !description.contains("by")) {
            ErrorHandler.handleEmptyDeadline();
            Nanat.startCommandLoop(taskList);
        }

        while(description.charAt(0) == ' ') {
            description.substring(1).trim();
        }

        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            ErrorHandler.handleEmptyDeadline();
            Nanat.startCommandLoop(taskList);
        }

        int num = taskList.numOfTasks();
        Ui.showAddedMessage(2, description, num, taskList);
    }
    /**
     * Handles the creation of an Event task.
     *
     * @param command The user input command.
     * @param taskList The TaskList to store the task.
     */
    private static void handleEvent(String command, TaskList taskList) {
        String description = command.substring(5).trim();

        if (description.isEmpty() || !description.contains("from") || !description.contains("to")) {
            ErrorHandler.handleEmptyEvent();
            Nanat.startCommandLoop(taskList);
        }

        while(description.charAt(0) == ' ') {
            description.substring(1).trim();
        }

        String[] parts = description.split(" /from ", 2);
        String[] timeParts = parts[1].split(" /to ", 2);

        if (!parts[1].contains(" /to ") || parts[0].trim().isEmpty() || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
            ErrorHandler.handleEmptyEvent();
            Nanat.startCommandLoop(taskList);
        }

        int num = taskList.numOfTasks();
        Ui.showAddedMessage(3, description, num, taskList);
    }
}