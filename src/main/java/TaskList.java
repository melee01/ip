import java.util.ArrayList;
import java.util.Scanner;

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
            Task task = tasks.get(index);
            if (task.getStatusIcon().equals(" ")) {
                // Task is already unmarked, show error message
                ErrorHandler.handleTaskAlreadyUnmarked(task);
            } else {
                task.markAsNotDone();
                Ui.showUnmarkMessage(task);
            }
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