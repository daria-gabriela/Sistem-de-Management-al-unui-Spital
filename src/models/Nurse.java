package models;

/**
 * Clasă care reprezintă un asistent medical.
 * Extinde `MedicalStaff`.
 */
public class Nurse extends MedicalStaff {
    public Nurse(int id, String name, String specialization) {
        super(id, name, specialization);
    }

    @Override
    public String toString() {
        return "Nurse: " + getLastName()+" "+getFirstName()+ ", Specialization: " + specialization;
    }
}
