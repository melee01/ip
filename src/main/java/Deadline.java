import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a task with a deadline that needs to be completed before a specific date/time.
 */
public class Deadline extends Task {

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
     * Returns a string representation of the deadline task.
     *
     * @return A formatted string indicating that this is a deadline task with its deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}