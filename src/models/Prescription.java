package models;

import java.util.List;

/**
 * Reprezintă o rețetă medicală emisă de un doctor pentru un pacient.
 */
public class Prescription {
    private Patient patient;
    private List<String> medications;

    public Prescription(Patient patient, List<String> medications) {
        this.patient = patient;
        this.medications = medications;
    }

    public Patient getPatient() { return patient; }
    public List<String> getMedications() { return medications; }

    @Override
    public String toString() {
        return "Prescription for " + patient.getFirstName() + ": " + String.join(", ", medications);
    }
}
