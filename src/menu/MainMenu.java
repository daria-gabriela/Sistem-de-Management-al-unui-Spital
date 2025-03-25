package menu;

import models.*;
import services.HospitalService;

import java.util.Date;
import java.util.Scanner;

/**
 * Clasa Singleton care gestionează meniul interactiv al aplicației.
 */
public class MainMenu {
    private static MainMenu instance = null; // Instanța Singleton
    private HospitalService hospitalService; // Serviciul principal al aplicației
    private Scanner scanner; // Scanner pentru citirea de la tastatură

    private MainMenu() {
        hospitalService = new HospitalService();
        scanner = new Scanner(System.in);
    }

    /**
     * Obține instanța unică a meniului (Singleton).
     *
     * @return Instanța meniului
     */
    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

    /**
     * Afișează meniul principal și gestionează interacțiunile cu utilizatorul.
     */
    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n🏥 Hospital Management System 🏥");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Show Patients");
            System.out.println("5. Show Doctors");
            System.out.println("6. Search Patient by CNP");
            System.out.println("7. Update Diagnosis");
            System.out.println("8. Cancel Appointment");
            System.out.println("9. Show Appointments for Doctor");
            System.out.println("10. Show Medical History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumă newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    scheduleAppointment();
                    break;
                case 4:
                    showPatients();
                    break;
                case 5:
                    showDoctors();
                    break;
                case 6:
                    searchPatientByCNP();
                    break;
                case 7:
                    updateDiagnosis();
                    break;
                case 8:
                    cancelAppointment();
                    break;
                case 9:
                    showAppointmentsForDoctor();
                    break;
                case 10:
                    showMedicalHistory();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the system... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Adaugă un pacient nou
    private void addPatient() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter CNP: ");
        String cnp = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        Patient patient = new Patient(hospitalService.getPatients().size() + 1, firstName, lastName, cnp,age);
        hospitalService.addPatient(patient);
    }

    // Adaugă un medic nou
    private void addDoctor() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(hospitalService.getDoctors().size() + 1, firstName, lastName, specialization);
        hospitalService.addDoctor(doctor);
    }

    // Programează o consultație
    private void scheduleAppointment() {
        System.out.print("Enter patient CNP: ");
        String cnp = scanner.nextLine();
        Patient patient = hospitalService.findPatientByCNP(cnp);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();
        Doctor doctor = hospitalService.findDoctorBySpecialization(specialization);

        if (doctor == null) {
            System.out.println("No doctor found with this specialization!");
            return;
        }

        hospitalService.scheduleAppointment(patient, doctor, new Date());
    }

    // Afișează toți pacienții
    private void showPatients() {
        hospitalService.showAllPatients();
    }

    //  Afișează toți medicii
    private void showDoctors() {
        hospitalService.showAllDoctors();
    }

    // Caută pacient după CNP
    private void searchPatientByCNP() {
        System.out.print("Enter CNP: ");
        String cnp = scanner.nextLine();
        Patient patient = hospitalService.findPatientByCNP(cnp);

        if (patient != null) {
            System.out.println("Patient found: " + patient);
        } else {
            System.out.println("No patient found with this CNP!");
        }
    }

    //  Actualizează diagnosticul unui pacient
    private void updateDiagnosis() {
        System.out.print("Enter patient CNP: ");
        String cnp = scanner.nextLine();
        Patient patient = hospitalService.findPatientByCNP(cnp);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter new diagnosis: ");
        String diagnosis = scanner.nextLine();
        hospitalService.updateDiagnosis(patient, diagnosis);
    }

    //  Anulează o programare
    private void cancelAppointment() {
        System.out.print("Enter patient CNP: ");
        String cnp = scanner.nextLine();
        Patient patient = hospitalService.findPatientByCNP(cnp);

        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();
        Doctor doctor = hospitalService.findDoctorBySpecialization(specialization);

        if (doctor == null) {
            System.out.println("No doctor found with this specialization!");
            return;
        }

        hospitalService.cancelAppointment(patient, doctor);
    }

    // Afișează consultațiile unui medic
    private void showAppointmentsForDoctor() {
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();
        Doctor doctor = hospitalService.findDoctorBySpecialization(specialization);

        if (doctor != null) {
            hospitalService.showAppointmentsForDoctor(doctor);
        } else {
            System.out.println("No doctor found!");
        }
    }

    // ✅ Afișează istoricul medical al unui pacient
    private void showMedicalHistory() {
        System.out.print("Enter patient CNP: ");
        String cnp = scanner.nextLine();
        Patient patient = hospitalService.findPatientByCNP(cnp);

        if (patient != null) {
            hospitalService.showMedicalHistory(patient);
        } else {
            System.out.println("No patient found!");
        }
    }
}
