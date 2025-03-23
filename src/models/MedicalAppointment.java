package models;

import java.time.LocalDateTime;

/**
 * Reprezintă o programare medicală.
 */
public class MedicalAppointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDate;

    public MedicalAppointment(Patient patient, Doctor doctor, LocalDateTime appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getAppointmentDate() { return appointmentDate; }

    @Override
    public String toString() {
        return "Appointment: " + patient.getFirstName() + " with " + doctor.getLastName() +" "+doctor.getFirstName()+ " on " + appointmentDate;
    }
}
