// ContactServiceTest.java
// Unit tests for the ContactService class.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        // fresh service for each test so they do not overlap
        service = new ContactService();
    }

    @Test
    void canAddContactWithUniqueId() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        Contact contact = service.getContact("1");
        assertNotNull(contact);
        assertEquals("John", contact.getFirstName());
    }

    @Test
    void cannotAddContactWithDuplicateId() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact("1", "Jane", "Smith", "0987654321", "456 Elm Street");
        });
    }

    @Test
    void canDeleteExistingContact() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    void deletingMissingContactThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    void canUpdateFirstNameOnExistingContact() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        service.updateFirstName("1", "Jane");
        Contact contact = service.getContact("1");

        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void canUpdateLastNameOnExistingContact() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        service.updateLastName("1", "Smith");
        Contact contact = service.getContact("1");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void canUpdatePhoneOnExistingContact() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        service.updatePhone("1", "0987654321");
        Contact contact = service.getContact("1");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void canUpdateAddressOnExistingContact() {
        service.addContact("1", "John", "Doe", "1234567890", "123 Main Street");

        service.updateAddress("1", "456 Elm Street");
        Contact contact = service.getContact("1");

        assertEquals("456 Elm Street", contact.getAddress());
    }

    @Test
    void updatingMissingContactThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Nope");
        });
    }
}
