package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care reprezintă dosarul medical al unui pacient.
 * Stochează istoricul consultațiilor și tratamentelor pacientului.
 */
public class MedicalRecord {
    private List<String> consultations; // Listă cu toate consultațiile pacientului
    private List<String> treatments; // Listă cu tratamentele administrate pacientului

    /**
     * Constructor care inițializează listele goale pentru consultații și tratamente.
     */
    public MedicalRecord() {
        this.consultations = new ArrayList<>();
        this.treatments = new ArrayList<>();
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
     * @return String cu detalii despre consultații și tratamente
     */
    @Override
    public String toString() {
        return "Medical Record:\n" +
                "Consultations: " + consultations + "\n" +
                "Treatments: " + treatments;
    }
}
