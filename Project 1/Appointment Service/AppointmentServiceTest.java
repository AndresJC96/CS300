package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    private Date getFutureDate(int daysInFuture) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, daysInFuture);
        return cal.getTime();
    }

    @Test
    public void testAddAppointmentSuccessfully() {
        Date futureDate = getFutureDate(1);
        service.addAppointment("A1", futureDate, "Dentist appointment");

        Appointment appt = service.getAppointment("A1");
        assertNotNull(appt);
        assertEquals("A1", appt.getAppointmentId());
        assertEquals("Dentist appointment", appt.getDescription());
    }

    @Test
    public void testAddAppointmentDuplicateIdNotAllowed() {
        Date futureDate = getFutureDate(1);
        service.addAppointment("A1", futureDate, "Dentist appointment");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment("A1", getFutureDate(2), "Eye appointment");
        });
    }

    @Test
    public void testDeleteAppointmentSuccessfully() {
        Date futureDate = getFutureDate(1);
        service.addAppointment("A1", futureDate, "Dentist appointment");
        assertNotNull(service.getAppointment("A1"));

        service.deleteAppointment("A1");

        assertNull(service.getAppointment("A1"));
    }

    @Test
    public void testDeleteAppointmentThatDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("NoSuchId");
        });
    }
}
