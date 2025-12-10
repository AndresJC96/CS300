package test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add a new appointment
    public void addAppointment(String appointmentId, Date appointmentDate, String description) {
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
        appointments.put(appointmentId, appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        appointments.remove(appointmentId);
    }

    // Optional helper to retrieve an appointment (useful for testing)
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
