import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a ToDo task, which has no specific date or time attached.
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with a description.
     *
     * @param description The description of the ToDo task.
     */
    public ToDo(String description) {
        super(description); // Calls the Task constructor to set description
    }

    /**
     * Returns a string representation of the ToDo task.
     *
     * @return A formatted string indicating the ToDo task's description.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
