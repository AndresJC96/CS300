package task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    // Adding a valid task should work
    @Test
    public void testAddTaskSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task One", "First task description");

        service.addTask(task);

        assertEquals(1, service.getTasks().size());
        assertEquals("1", service.getTasks().get(0).getTaskId());
    }

    // Adding a task with a duplicate ID should fail
    @Test
    public void testAddTaskWithDuplicateIdThrowsException() {
        TaskService service = new TaskService();
        Task task1 = new Task("1", "Task One", "First task description");
        Task task2 = new Task("1", "Task Two", "Second task description");

        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    // Make sure deleting actually removes the task
    @Test
    public void testDeleteTaskSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task One", "First task description");
        service.addTask(task);

        service.deleteTask("1");

        assertEquals(0, service.getTasks().size());
    }

    // Deleting something that doesn't exist should fail
    @Test
    public void testDeleteNonexistentTaskThrowsException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("999");
        });
    }

    // Updating name should work when ID exists
    @Test
    public void testUpdateTaskNameSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Old Name", "Description");
        service.addTask(task);

        service.updateTaskName("1", "New Name");

        assertEquals("New Name", service.getTasks().get(0).getName());
    }

    // Updating description should also work
    @Test
    public void testUpdateTaskDescriptionSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Name", "Old Description");
        service.addTask(task);

        service.updateTaskDescription("1", "New Description");

        assertEquals("New Description", service.getTasks().get(0).getDescription());
    }

    // Updating name for a task that isn't there should fail
    @Test
    public void testUpdateNameForNonexistentTaskThrowsException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("999", "New Name");
        });
    }

    // Same thing for updating description
    @Test
    public void testUpdateDescriptionForNonexistentTaskThrowsException() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("999", "New Description");
        });
    }
}
