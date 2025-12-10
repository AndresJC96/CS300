// Contact.java
// This class holds a single contact for the app.

public class Contact {

    // contactId is required and cannot change after it is set
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor checks all the requirements from the rubric
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        // contactId: required, not null, max 10 characters
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // firstName: required, not null, max 10 characters
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // lastName: required, not null, max 10 characters
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // phone: required, not null, exactly 10 digits
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // address: required, not null, max 30 characters
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for fields that are allowed to change
    // ID does not get a setter on purpose

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
