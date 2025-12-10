package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    // Helper to get a future date
    private Date getFutureDate(int daysInFuture) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, daysInFuture);
        return cal.getTime();
    }

    // Helper to get a past date
    private Date getPastDate(int daysInPast) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -daysInPast);
        return cal.getTime();
    }

    @Test
    public void testValidAppointment() {
        Date futureDate = getFutureDate(1);
        Appointment appointment = new Appointment("12345", futureDate, "Regular checkup");
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Regular checkup", appointment.getDescription());
    }

    @Test
    public void testAppointmentIdTooLong() {
        Date futureDate = getFutureDate(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Regular checkup");
        });
    }

    @Test
    public void testAppointmentIdNull() {
        Date futureDate = getFutureDate(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Regular checkup");
        });
    }

    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Regular checkup");
        });
    }

    @Test
    public void testAppointmentDateInPast() {
        Date pastDate = getPastDate(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Regular checkup");
        });
    }

    @Test
    public void testDescriptionNull() {
        Date futureDate = getFutureDate(1);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    @Test
    public void testDescriptionTooLong() {
        Date futureDate = getFutureDate(1);
        String longDescription = "This description is definitely longer than fifty characters long";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, longDescription);
        });
    }

    @Test
    public void testUpdateDescription() {
        Date futureDate = getFutureDate(2);
        Appointment appointment = new Appointment("12345", futureDate, "Old description");
        appointment.setDescription("New description");
        assertEquals("New description", appointment.getDescription());
    }

    @Test
    public void testUpdateDate() {
        Date futureDate = getFutureDate(2);
        Appointment appointment = new Appointment("12345", futureDate, "Regular checkup");
        Date newFutureDate = getFutureDate(5);
        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());
    }

    @Test
    public void testUpdateDateToPastNotAllowed() {
        Date futureDate = getFutureDate(2);
        Appointment appointment = new Appointment("12345", futureDate, "Regular checkup");
        Date pastDate = getPastDate(2);

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(pastDate);
        });
    }
}
