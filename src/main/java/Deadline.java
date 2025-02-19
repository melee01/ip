/**
 * Represents a task with a deadline.
 */
class Deadline extends Task {

    private String by;

    /**
     * Constructs a Deadline task with a description and a deadline.
     *
     * @param description The description of the task.
     * @param by The deadline for the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the task type identifier for Deadline.
     */
    @Override
    public String getTaskType() {
        return "[D]";
    }

    /**
     * Returns a string representation of the deadline task.
     */
    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}