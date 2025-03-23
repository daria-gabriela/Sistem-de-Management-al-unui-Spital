package models;

/**
 * Clasa care reprezintă un medic într-un spital.
 * Medicul poate efectua consultații și emite rețete medicale.
 */
public class Doctor extends MedicalStaff {
    private String specialization; // Specializarea medicului (ex: Cardiologie, Neurologie)

    /**
     * Constructor pentru inițializarea unui medic.
     *
     * @param id            ID-ul medicului
     * @param firstName     Prenumele medicului
     * @param lastName      Numele de familie al medicului
     * @param specialization Specializarea medicului
     */
    public Doctor(int id, String firstName, String lastName, String specialization) {
        super(id, firstName, lastName);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    @Override
    public String toString() {
        return "Doctor: " + getFirstName() + " " + getLastName() + ", Specialization: " + specialization;
    }
}
