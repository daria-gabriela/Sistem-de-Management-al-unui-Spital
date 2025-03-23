package models;

/**
 * Clasă abstractă care definește personalul medical (medici, asistenți).
 */
public abstract class MedicalStaff {
    protected int id;               // ID unic pentru personalul medical
    protected String firstName;     // Prenumele personalului medical
    protected String lastName;      // Numele de familie al personalului medical
    protected String specialization;

    public MedicalStaff(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }  // Metodă getter pentru firstName
    public String getLastName() { return lastName; }    // Metodă getter pentru lastName

    @Override
    public String toString() {
        return "Medical Staff: " + firstName + " " + lastName;
    }
}
