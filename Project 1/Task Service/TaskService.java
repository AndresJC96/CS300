package task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    // Just storing tasks in a list since we aren't using a database
    private final List<Task> tasks = new ArrayList<>();

    // Add a new task as long as the ID hasn't been used before
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        // Make sure the ID is unique
        for (Task existingTask : tasks) {
            if (existingTask.getTaskId().equals(task.getTaskId())) {
                throw new IllegalArgumentException("Task ID must be unique");
            }
        }

        tasks.add(task);
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        Task taskToDelete = findTaskById(taskId);
        tasks.remove(taskToDelete);
    }

    // Update the name on a specific task
    public void updateTaskName(String taskId, String newName) {
        Task taskToUpdate = findTaskById(taskId);
        taskToUpdate.setName(newName);
    }

    // Update the description on a specific task
    public void updateTaskDescription(String taskId, String newDescription) {
        Task taskToUpdate = findTaskById(taskId);
        taskToUpdate.setDescription(newDescription);
    }

    // Finds a task by ID or throws an error if it doesn't exist
    private Task findTaskById(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }

        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }

        throw new IllegalArgumentException("Task with ID " + taskId + " not found");
    }

    // Used in testing to check what tasks are stored
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}
