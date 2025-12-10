// ContactService.java
// This class manages a group of Contact objects in memory.

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Using a HashMap so each contact is stored by its ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    // ID must be unique or we throw an exception
    public void addContact(String contactId, String firstName, String lastName,
                           String phone, String address) {

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }

        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, contact);
    }

    // Remove a contact using the ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Update first name for a contact
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContactById(contactId);
        contact.setFirstName(newFirstName);
    }

    // Update last name for a contact
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContactById(contactId);
        contact.setLastName(newLastName);
    }

    // Update phone number for a contact
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContactById(contactId);
        contact.setPhone(newPhone);
    }

    // Update address for a contact
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContactById(contactId);
        contact.setAddress(newAddress);
    }

    // Helper to find a contact or throw an error if it does not exist
    private Contact getContactById(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contact;
    }

    // This getter is here to help in the unit tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
