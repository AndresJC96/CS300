// ContactTest.java
// Unit tests for the Contact class.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void contactIsCreatedWithValidData() {
        Contact contact = new Contact("12345", "John", "Doe",
                "1234567890", "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void contactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void contactIdCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void firstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void firstNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIsTooLong", "Doe",
                    "1234567890", "123 Main Street");
        });
    }

    @Test
    void lastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    void lastNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "ThisNameIsTooLong",
                    "1234567890", "123 Main Street");
        });
    }

    @Test
    void phoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345",
                    "123 Main Street");
        });
    }

    @Test
    void phoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null,
                    "123 Main Street");
        });
    }

    @Test
    void addressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    void addressCannotBeLongerThanThirtyCharacters() {
        String longAddress = "123 Main Street City Name Too Long";

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", longAddress);
        });
    }

    @Test
    void canUpdateFirstNameWithValidValue() {
        Contact contact = new Contact("12345", "John", "Doe",
                "1234567890", "123 Main Street");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void cannotUpdateFirstNameWithInvalidValue() {
        Contact contact = new Contact("12345", "John", "Doe",
                "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsTooLong");
        });
    }
}
