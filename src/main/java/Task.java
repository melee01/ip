/**
 * Represents a task with a description, type, and completion status.
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
        return isDone ? "[X]" : "[ ]";
    }

    /**
     * Returns the prefix based on the task type.
     */
    public String getTaskType() {
        return "";
    }

    /**
     * Returns a string representation of the task, including its type, status, and description.
     *
     * @return A string in the format "[type][status] description" (e.g., "[T][X] Task description").
     */
    @Override
    public String toString() {
        return getTaskType() + getStatusIcon() + " " + description;
    }
}