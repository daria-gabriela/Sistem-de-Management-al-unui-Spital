package models;

import java.time.LocalDateTime;

/**
 * Reprezintă o consultație între un pacient și un medic.
 */
public class Consultation {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime date;
    private String diagnosis;

    public Consultation(Patient patient, Doctor doctor, LocalDateTime date, String diagnosis) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.diagnosis = diagnosis;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getDate() { return date; }
    public String getDiagnosis() { return diagnosis; }

    @Override
    public String toString() {
        return "Consultation: " + patient.getFirstName() + " - " + doctor.getLastName() + ", Date: " + date + ", Diagnosis: " + diagnosis;
    }
}
