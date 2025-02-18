import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the user interface, displaying various messages and outputs.
 */
class Ui {

    /**
     * Displays a welcome message when the program starts.
     */
    public static void showWelcomeMessage() {
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
    }

    /**
     * Displays a goodbye message when the program ends.
     */
    public static void showGoodbyeMessage() {
        System.out.println("____________________________________________________________");
        System.out.println("     Bye. Have a great day!");
        System.out.println("____________________________________________________________");
    }

    /**Tweak the code to comply with a coding standard

     Tweak the code to comply with a given coding standard. From this point onward, ensure any new code added are compliant with the given coding standard.
     * Displays the list of tasks currently stored in the task list.
     *
     * @param tasks The list of tasks to be displayed.
     */
    public static void showTaskList(ArrayList<Task> tasks) {
        System.out.println("____________________________________________________________");
        if (tasks.isEmpty()) {
            System.out.println("     No tasks found.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message indicating that a task is added to the task list.
     * It also displays the details of the task and updates the total number of tasks in the list.
     *
     * This method determines the type of task based on the provided `types` value (1 for ToDo, 2 for Deadline, 3 for Event),
     * creates the corresponding task object, and adds it to the task list. It then prints a confirmation message with the task details
     * and the updated number of tasks in the list.
     *
     * @param types The type of the task (1 for ToDo, 2 for Deadline, 3 for Event).
     * @param description The description of the task, which may contain additional details such as a deadline or event timing.
     * @param num The current number of tasks in the list before the new task is added.
     * @param taskList The list of tasks to which the new task will be added.
     */
    public static void showAddedMessage(int types, String description, int num, TaskList taskList) {
        System.out.println("____________________________________________________________");
        System.out.println("     Got it. I've added this task:");

        num = num + 1;
        Task task = null;  // Store the actual Task object

        if (types == 1) {
            task = new ToDo(description);
        } else if (types == 2) {
            String[] parts = description.split(" /by ", 2);
            task = new Deadline(parts[0].trim(), parts[1].trim());
        } else if (types == 3) {
            String[] parts = description.split(" /from ", 2);
            String[] timeParts = parts[1].split(" /to ", 2);
            task = new Event(parts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
        }

        if (task != null) {
            taskList.addTask(task);  // Add the actual Task object, not a formatted string
            System.out.println("        " + task);
        }

        System.out.println("     Now you have " + num + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message confirming the deletion of a task.
     *
     * @param task The task that was deleted.
     * @param num  The number of remaining tasks in the list.
     */
    public static void showDeleteTaskMessage(Task task, int num) {

        System.out.println("____________________________________________________________");
        System.out.println("     Noted. Task deleted:");
        System.out.println("       " + task);
        System.out.println("     Now you have " + num + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when a task is marked as done.
     *
     * @param task The task that has been marked as done.
     */
    public static void showMarkMessage(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("     " + task);
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when a task is unmarked.
     *
     * @param task The task that has been unmarked.
     */
    public static void showUnmarkMessage(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println("     Oh no! Come back again pls, so many tasks to do!");
        System.out.println("     " + task);
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when an invalid task number is entered.
     */
    public static void showInvalidTaskMessage() {
        System.out.println("     Invalid task number.");
    }
}