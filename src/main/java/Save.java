import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {

    private static final String FILE_PATH = "./data/Nanat.txt";

    /**
     * Ensures that the data file exists. If it does not, creates the necessary directories and file.
     */
    public static void ensureDataFileExists() {
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile();

        try {
            if (!file.exists()) {
                file.createNewFile(); // Create the file
                System.out.println("Data file created at: " + FILE_PATH);
            }
        } catch (IOException e) {
            System.err.println("Error creating data file: " + e.getMessage());
        }
    }

    /**
     * Writes the task to the Nanat.txt file.
     *
     * @param task The task to be written to the file.
     */
    public static void writeTaskToFile(Task task) {
        FileWriter fileWriter = null;
        try {
            // Open the file in append mode (so we don't overwrite existing content)
            fileWriter = new FileWriter(FILE_PATH, true);

            // Write the task to the file
            fileWriter.write(task.toString() + System.lineSeparator());  // Writing task as a string

            //System.out.println("Task saved to file: " + task);

        } catch (IOException e) {
            System.err.println("An error occurred while writing the task to the file.");
            e.printStackTrace();
        } finally {
            // Ensure the FileWriter is properly closed
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file writer.");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Updates the file by rewriting all tasks without the removed task.
     */
    public static void updateTasksToFile(ArrayList<Task> tasks) {
        try {
            // Create a new FileWriter to overwrite the file
            FileWriter fileWriter = new FileWriter(FILE_PATH);

            // Re-write all tasks to the file
            for (Task task : tasks) {
                fileWriter.write(task.toString() + System.lineSeparator());
            }

            // Close the writer
            fileWriter.close();
            //System.out.println("File updated successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while updating the file.");
            e.printStackTrace();
        }
    }

    /**
     * Loads the tasks from the Nanat.txt file and adds them to the TaskList.
     */
    public static void loadTasksFromFile(TaskList taskList) {
        File file = new File(FILE_PATH);

        // Ensure the file exists
        if (!file.exists()) {
            return; // No tasks to load
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                Task task;

                if (line.length() > 1) {
                    char type = line.charAt(1); // Extracts task type (T, D, etc.)

                    if (type == 'T') {
                        String command = line.substring(7).trim(); // Extracts task description
                        task = new ToDo(command);
                    } else if (type == 'D') {
                        int byIndex = line.indexOf("(by:");
                        String description = line.substring(7, byIndex).trim();
                        String by = line.substring(byIndex + 5, line.length() - 1).trim();
                        task = new Deadline(description, by);
                    } else if (type == 'E') {
                        // Extract description, start time, and end time
                        int fromIndex = line.indexOf("(from:");
                        int toIndex = line.indexOf("to:");
                        String description = line.substring(7, fromIndex).trim();
                        String from = line.substring(fromIndex + 6, toIndex).trim();
                        String to = line.substring(toIndex + 3, line.length() - 1).trim();
                        task = new Event(description, from, to);
                    } else {
                        task = new Task(line); // Default fallback
                    }

                    // If task is successfully created
                    if (task != null) {
                        taskList.setTask(index, task); // Assign task at index
                        index++;

                        // check if it's marked done
                        if(line.charAt(4) == 'X') {
                            task.markAsDone();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading tasks from the file.");
            e.printStackTrace();
        }
    }
}