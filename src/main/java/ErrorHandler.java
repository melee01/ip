import java.util.ArrayList;
import java.util.Scanner;

public class ErrorHandler {

    /**
     * Handles number format exceptions.
     */
    public static void handleNumberFormatException() {
        Ui.showInvalidTaskMessage();
    }

    /**
     * Handles the case when an attempt is made to unmark a task that is already not marked.
     *
     * @param task The task that is already unmarked.
     */
    public static void handleTaskAlreadyUnmarked(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println("     Task is already unmarked: " + task);
        System.out.println("     You cannot unmark a task that is already not done.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Handles the case when a description is empty.
     * This method displays a message indicating that the description cannot be empty.
     */
    public static void handleEmptyDescription() {
        System.out.println("____________________________________________________________");
        System.out.println("     OOPS!!! Description cannot be empty.");
        System.out.println("     Please input again");
        System.out.println("____________________________________________________________");
    }

    /**
     * Handles the case when the deadline format is invalid.
     * This method displays a message indicating that the deadline format is incorrect.
     * It suggests the correct format: "deadline <description> /by <time>".
     */
    public static void handleEmptyDeadline() {
        System.out.println("____________________________________________________________");
        System.out.println("     OOPS!!! Invalid deadline format. Use: deadline <description> /by <time>");
        System.out.println("     Please input again");
        System.out.println("____________________________________________________________");
    }
    /**
     * Handles the case when the event format is invalid.
     * This method displays a message indicating that the event format is incorrect.
     * It suggests the correct format: "event <description> /from <start> /to <end>".
     */
    public static void handleEmptyEvent() {
        System.out.println("____________________________________________________________");
        System.out.println("     OOPS!!! Invalid event format. Use: event <description> /from <start> /to <end>");
        System.out.println("     Please input again");
        System.out.println("____________________________________________________________");
    }
}