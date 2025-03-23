package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezintă o secție medicală din spital.
 * Fiecare secție are un nume și o listă de medici care lucrează în acea secție.
 */
public class MedicalDepartment {
    private String name;           // Numele secției medicale
    private List<Doctor> doctors;  // Lista medicilor din secție

    public MedicalDepartment(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Adaugă un medic în secție
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Elimină un medic din secție
    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    // Returnează numele secției
    public String getName() {
        return name;
    }

    // Returnează lista medicilor
    public List<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Medical Department: " + name + "\nDoctors:\n");
        for (Doctor doc : doctors) {
            sb.append("- ").append(doc.getFirstName()).append(" ").append(doc.getLastName()).append(" (").append(doc.getSpecialization()).append(")\n");
        }
        return sb.toString();
    }
}
