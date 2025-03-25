package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care reprezintă dosarul medical al unui pacient.
 * Stochează istoricul consultațiilor, tratamentelor și diagnosticul curent.
 */
public class MedicalRecord {
    private String diagnosis; // Diagnosticul curent al pacientului
    private List<String> consultations; // Lista tuturor consultațiilor pacientului
    private List<String> treatments; // Lista tratamentelor administrate pacientului

    /**
     * Constructor care inițializează un dosar medical gol.
     */
    public MedicalRecord() {
        this.diagnosis = "Unknown"; // Diagnosticul implicit
        this.consultations = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    /**
     * Setează un nou diagnostic pentru pacient.
     *
     * @param diagnosis Noul diagnostic
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Returnează diagnosticul actual al pacientului.
     *
     * @return Diagnosticul pacientului
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Adaugă o nouă consultație în dosarul medical.
     *
     * @param consultation Descrierea consultației
     */
    public void addConsultation(String consultation) {
        consultations.add(consultation);
    }

    /**
     * Adaugă un nou tratament în dosarul medical.
     *
     * @param treatment Descrierea tratamentului
     */
    public void addTreatment(String treatment) {
        treatments.add(treatment);
    }

    /**
     * Returnează lista tuturor consultațiilor pacientului.
     *
     * @return Lista consultațiilor
     */
    public List<String> getConsultations() {
        return consultations;
    }

    /**
     * Returnează lista tuturor tratamentelor pacientului.
     *
     * @return Lista tratamentelor
     */
    public List<String> getTreatments() {
        return treatments;
    }

    /**
     * Suprascrie metoda toString() pentru a returna un rezumat al dosarului medical.
     *
     * @return String cu detalii despre diagnosticul curent, consultații și tratamente
     */
    @Override
    public String toString() {
        return "Medical Record:\n" +
                "Diagnosis: " + diagnosis + "\n" +
                "Consultations: " + consultations + "\n" +
                "Treatments: " + treatments;
    }
}
