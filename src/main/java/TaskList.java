import java.util.ArrayList;

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
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Displays all tasks in the task list.
     */
    public void listTasks() {
        Ui.showTaskList(tasks);
    }

    /**
     * Displays number of tasks in the list
     */
    public int numOfTasks() {
        return this.tasks.size();
    }

    /**
     * Marks a task as done based on the provided index.
     * The task will be updated and the UI will show a confirmation message.
     *
     * @param index The index of the task to mark as done.
     * @throws IndexOutOfBoundsException if the index is invalid (out of bounds).
     */
    public void markTask(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            task.markAsDone();
            Ui.showMarkMessage(task); // Convert Task to String
        } else {
            Ui.showInvalidTaskMessage();
        }
    }

    /**
     * Unmarks a task as done based on the provided index.
     * If the task is already unmarked, an error message is displayed.
     * If the task is marked as done, it will be unmarked and the UI will show a confirmation message.
     *
     * @param index The index of the task to unmark.
     * @throws IndexOutOfBoundsException if the index is invalid (out of bounds).
     */
    public void unmarkTask(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            if (!task.getStatusIcon().equals("[X]")) {
                ErrorHandler.handleTaskAlreadyUnmarked(task);
            } else {
                task.markAsNotDone();
                Ui.showUnmarkMessage(task); // Convert Task to String
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