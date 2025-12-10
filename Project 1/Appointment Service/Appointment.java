package test;

import java.util.Date;

public class Appointment {

    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointmentId
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        // Validate appointmentDate
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null");
        }
        // Date cannot be in the past
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters for fields that ARE allowed to change

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
