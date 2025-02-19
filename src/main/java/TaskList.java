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
     * @param task The description of the task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void setTask(int index, Task task) {
        if (index < tasks.size()) {
            tasks.set(index, task); // Replace existing task at index
        } else {
            tasks.add(task); // Add new task if index exceeds current size
        }
    }

    /**
     * Deletes a task from the task list at the specified index.
     * If the index is valid, the task is removed, and a confirmation message is displayed.
     * Otherwise, an error message is printed.
     *
     * @param index The index of the task to be deleted.
     * @param num   The updated number of tasks in the list after deletion.
     */
    public void deleteTask(int index, int num) {
        if (isValidIndex(index)) {
            Task removedTask = tasks.remove(index);

            Ui.showDeleteTaskMessage(removedTask, num);
        } else {
            System.out.println("Invalid task index!");
        }

        // Update the file after task removal
        Save.updateTasksToFile(tasks);
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

            // Update the file after task marked
            Save.updateTasksToFile(tasks);
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

                // Update the file after task unmarked
                Save.updateTasksToFile(tasks);
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