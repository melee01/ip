/**
 * Represents a ToDo task, which has no specific date or time attached.
 */
class ToDo extends Task {
    /**
     * Constructs a ToDo task with a description.
     *
     * @param description The description of the ToDo task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for ToDo.
     */
    @Override
    public String getTaskType() {
        return "[T]";
    }
}