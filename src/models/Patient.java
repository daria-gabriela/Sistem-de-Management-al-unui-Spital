package models;

/**
 * Clasa care reprezintă un pacient într-un spital.
 * Conține informații precum ID, nume, CNP și vârstă,
 * precum și un dosar medical asociat.
 */
public class Patient {
    private int id; // ID unic al pacientului
    private String firstName; // Prenumele pacientului
    private String lastName; // Numele de familie al pacientului
    private String cnp; // Cod Numeric Personal (CNP) al pacientului
    private int age; // Vârsta pacientului
    private MedicalRecord medicalRecord; // Dosarul medical al pacientului

    /**
     * Constructor pentru inițializarea unui pacient cu date de bază.
     *
     * @param id        ID-ul pacientului
     * @param firstName Prenumele pacientului
     * @param lastName  Numele de familie al pacientului
     * @param cnp       Codul Numeric Personal
     * @param age       Vârsta pacientului
     */
    public Patient(int id, String firstName, String lastName, String cnp, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.age = age;
        this.medicalRecord = new MedicalRecord(); // Se inițializează un dosar medical gol
    }



    // Getters - metode care returnează valorile atributelor private

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public int getAge() {
        return age;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    // Setters - metode care modifică valorile atributelor private

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age > 0) { // Verificare pentru a evita vârste negative
            this.age = age;
        }
    }

    /**
     * Suprascrierea metodei toString() pentru a returna informațiile pacientului într-un format clar.
     *
     * @return String cu detalii despre pacient
     */
    @Override
    public String toString() {
        return "Patient: " + firstName + " " + lastName + ", CNP: " + cnp + ", Age: " + age;
    }
}
