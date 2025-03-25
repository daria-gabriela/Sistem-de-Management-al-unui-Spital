package models;

import java.util.Date;

/**
 * Reprezintă o programare medicală.
 */
public class MedicalAppointment {
    private Patient patient;
    private Doctor doctor;
    private Date appointmentDate;

    public MedicalAppointment(Patient patient, Doctor doctor, Date appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public Date getAppointmentDate() { return appointmentDate; }

    @Override
    public String toString() {
        return "Appointment: " + patient.getFirstName() + " with " + doctor.getLastName() +" "+doctor.getFirstName()+ " on " + appointmentDate;
    }
}
