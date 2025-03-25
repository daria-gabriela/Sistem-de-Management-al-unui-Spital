package services;

import models.Doctor;
import models.MedicalAppointment;
import models.MedicalDepartment;
import models.Patient;

import java.util.*;

/**
 * Clasa responsabilă pentru gestionarea pacienților, medicilor și consultațiilor într-un spital.
 */
public class HospitalService {
    private List<Patient> patients;                  // Lista pacienților
    private List<Doctor> doctors;                   // Lista medicilor
    private List<MedicalAppointment> appointments;  // Lista programărilor medicale
    private Map<String, MedicalDepartment> departments; // Secțiile medicale

    public HospitalService() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.departments = new HashMap<>();
    }

    // Adaugă un nou pacient în sistem
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient);
    }

    //  Adaugă un nou medic în sistem
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        // Adaugă medicul și în secția lui
        departments.putIfAbsent(doctor.getSpecialization(), new MedicalDepartment(doctor.getSpecialization()));
        departments.get(doctor.getSpecialization()).addDoctor(doctor);
        System.out.println("Doctor added: " + doctor);
    }

    // Creează o programare medicală
    public void scheduleAppointment(Patient patient, Doctor doctor, Date date) {
        MedicalAppointment appointment = new MedicalAppointment(patient, doctor, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled: " + appointment);
    }

    // Afișează toate programările unui medic
    public void showAppointmentsForDoctor(Doctor doctor) {
        System.out.println("Appointments for Dr. " + doctor.getLastName() + ":");
        for (MedicalAppointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                System.out.println(appointment);
            }
        }
    }

    // Actualizează diagnosticul unui pacient
    public void updateDiagnosis(Patient patient, String diagnosis) {
        patient.getMedicalRecord().setDiagnosis(diagnosis);
        System.out.println("Diagnosis updated for patient: " + patient.getLastName());
    }

    //  Anulează o programare medicală
    public void cancelAppointment(Patient patient, Doctor doctor) {
        appointments.removeIf(a -> a.getPatient().equals(patient) && a.getDoctor().equals(doctor));
        System.out.println("Appointment canceled for patient: " + patient.getLastName());
    }

    // Afișează pacienții unui medic
    public void showPatientsForDoctor(Doctor doctor) {
        System.out.println("Patients for Dr. " + doctor.getLastName() + ":");
        for (MedicalAppointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                System.out.println(appointment.getPatient());
            }
        }
    }

    //  Caută pacient după CNP
    public Patient findPatientByCNP(String cnp) {
        for (Patient patient : patients) {
            if (patient.getCnp().equals(cnp)) {
                return patient;
            }
        }
        return null;
    }

    //  Afișează istoricul medical al unui pacient
    public void showMedicalHistory(Patient patient) {
        System.out.println("Medical history for patient " + patient.getLastName() + ":");
        System.out.println(patient.getMedicalRecord());
    }

    //  Afișează toate consultațiile dintr-o secție medicală
    public void showConsultationsByDepartment(String departmentName) {
        MedicalDepartment department = departments.get(departmentName);
        if (department != null) {
            System.out.println("Consultations in department: " + departmentName);
            for (Doctor doctor : department.getDoctors()) {
                showAppointmentsForDoctor(doctor);
            }
        } else {
            System.out.println("No department found with name: " + departmentName);
        }
    }

    //  Returnează toți pacienții din sistem
    public List<Patient> getPatients() {
        return patients;
    }

    //  Returnează toți medicii din sistem
    public List<Doctor> getDoctors() {
        return doctors;
    }

    //  Caută un medic după specializare
    public Doctor findDoctorBySpecialization(String specialization) {
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                return doctor;
            }
        }
        return null;
    }

    //  Afișează toți pacienții
    public void showAllPatients() {
        System.out.println("All Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    //  Afișează toți medicii
    public void showAllDoctors() {
        System.out.println("All Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }
}
