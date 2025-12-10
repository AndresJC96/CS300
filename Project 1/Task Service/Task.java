package task;

public class Task {

    // Task ID never changes, so it's final
    private final String taskId;
    // Name and description can be updated
    private String name;
    private String description;

    // Constructor sets everything up and checks all rules
    public Task(String taskId, String name, String description) {

        // Task ID: required, not null, max 10 characters
        if (taskId == null || taskId.length() > 10 || taskId.isEmpty()) {
            throw new IllegalArgumentException("Invalid task ID");
        }

        // Name: required and max 20 characters
        if (name == null || name.length() > 20 || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid task name");
        }

        // Description: required and max 50 characters
        if (description == null || description.length() > 50 || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters for everything
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Name can change but still has to follow the rules
    public void setName(String name) {
        if (name == null || name.length() > 20 || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid task name");
        }
        this.name = name;
    }

    // Same for description — still needs to be valid
    public void setDescription(String description) {
        if (description == null || description.length() > 50 || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }
        this.description = description;
    }
}
