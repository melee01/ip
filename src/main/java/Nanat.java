import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a task with a description and completion status.
 */
class Task {
    private String description;
    private boolean isDone;

    /**
     * Constructs a Task with the specified description and sets its status to not done.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Returns the status icon for the task.
     *
     * @return A string representing the task's status. "X" if the task is done, otherwise a blank space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns a string representation of the task, including its status and description.
     *
     * @return A string in the format "[status] description" (e.g., "[X] Task description").
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

/**
 * Represents a list of tasks.
 */
class TaskList {

    private ArrayList<Task> tasks;
    /**
     * Constructs a TaskList object, initializing the list of tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param description The description of the task to be added.
     */
    public void addTask(String description) {
        tasks.add(new Task(description));
        Ui.showAddedMessage(description);
    }

    /**
     * Displays all tasks in the task list.
     */
    public void listTasks() {
        Ui.showTaskList(tasks);
    }

    /**
     * Marks a task as done based on the provided index.
     *
     * @param index The index of the task to mark as done.
     */
    public void markTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).markAsDone();
            Ui.showMarkMessage(tasks.get(index));
        } else {
            Ui.showInvalidTaskMessage();
        }
    }

    /**
     * Unmarks a task as done based on the provided index.
     *
     * @param index The index of the task to unmark.
     */
    public void unmarkTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).markAsNotDone();
            Ui.showUnmarkMessage(tasks.get(index));
        } else {
            Ui.showInvalidTaskMessage();
        }
    }

    /**
     * Checks if the provided index is valid in the task list.
     *
     * @param index The index to check.
     * @return True if the index is valid, false otherwise.
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}

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
        System.out.println("     Good Morning! I'm\n" + logo + "\nWhat brings you here today?");
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
            System.out.println("     Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message confirming the addition of a task.
     *
     * @param description The description of the added task.
     */
    public static void showAddedMessage(String description) {
        System.out.println("____________________________________________________________");
        System.out.println("     Added: " + description);
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

/**
 * Parses and handles user commands.
 */
class Parser {
    /**
     * Processes the user command and performs the corresponding action on the task list.
     *
     * @param command The command entered by the user.
     * @param taskList The task list to modify based on the command.
     */
    public static void handleCommand(String command, TaskList taskList) {
        if (command.equals("bye")) {
            Ui.showGoodbyeMessage();
            System.exit(0);
        } else if (command.equals("list")) {
            taskList.listTasks();
        } else if (command.startsWith("mark ")) {
            try {
                int taskNumber = Integer.parseInt(command.substring(5)) - 1;
                taskList.markTask(taskNumber);
            } catch (NumberFormatException e) {
                Ui.showInvalidTaskMessage();
            }
        } else if (command.startsWith("unmark ")) {
            try {
                int taskNumber = Integer.parseInt(command.substring(7)) - 1;
                taskList.unmarkTask(taskNumber);
            } catch (NumberFormatException e) {
                Ui.showInvalidTaskMessage();
            }
        } else {
            taskList.addTask(command);
        }
    }
}

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
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            Parser.handleCommand(command, taskList);
        }
    }
}
