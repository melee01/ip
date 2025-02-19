/**
 * Represents an event task that has a specific start and end date/time.
 */
class Event extends Task {

    private String from;
    private String to;

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start date/time of the event.
     * @param to The end date/time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the task type identifier for Event.
     */
    @Override
    public String getTaskType() {
        return "[E]";
    }

    /**
     * Returns a string representation of the Event task.
     */
    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }
}