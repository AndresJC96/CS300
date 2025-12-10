package task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    // Make sure a valid task actually gets created
    @Test
    public void testValidTaskCreation() {
        Task task = new Task("12345", "Test Task", "This is a test description.");
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    // Task ID can't be null
    @Test
    public void testTaskIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
    }

    // Task ID over 10 characters should fail
    @Test
    public void testTaskIdCannotBeLongerThan10() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Description");
        });
    }

    // Name can't be null
    @Test
    public void testNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Description");
        });
    }

    // Name can't be over 20 characters
    @Test
    public void testNameCannotBeLongerThan20() {
        String longName = "ThisNameIsWayTooLong";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", longName, "Description");
        });
    }

    // Description can't be null
    @Test
    public void testDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Name", null);
        });
    }

    // Description can't be too long
    @Test
    public void testDescriptionCannotBeLongerThan50() {
        String longDescription = "This description is definitely going to be more than fifty characters long.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Name", longDescription);
        });
    }

    // Updating name should work when valid
    @Test
    public void testUpdateNameValid() {
        Task task = new Task("12345", "Old Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    // Updating name with bad value should fail
    @Test
    public void testUpdateNameInvalid() {
        Task task = new Task("12345", "Old Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    // Updating description should work when valid
    @Test
    public void testUpdateDescriptionValid() {
        Task task = new Task("12345", "Name", "Old Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    // Invalid description update should fail
    @Test
    public void testUpdateDescriptionInvalid() {
        Task task = new Task("12345", "Name", "Old Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}
