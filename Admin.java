package mainModule;

import subModule.*;
import outModule.*;

import java.util.Scanner;

public class Admin {

    private String adminId = "admin";
    private String adminName = "admin";

    Patient patient;
    CommunityDoctor communityDoctor;
    HospitalDoctor hospitalDoctor;
    Diagnosis diagnosis;
    Medication medication;
    Surgery surgery;

    public Admin() {

    }

    public Admin(String adminId, String adminName) {
        this.adminId = adminId;
        this.adminName = adminName;
    }

    public void menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner in = new Scanner(System.in);
        Main.template();
        System.out.println("     1. Add\n" +
                "     2. Show\n\n" +
                "     0. Logout");
        System.out.print("\n     Choose an option: ");
        int option1 = in.nextInt();
        if (option1 == 1) {
            Main.template();
            System.out.println("     1. Add Patient\n" +
                    "     2. Add Community Doctor\n" +
                    "     3. Add Hospital Doctor\n" +
                    "     4. Add Diagnosis\n" +
                    "     5. Add Medication\n" +
                    "     6. Add Surgery\n\n" +
                    "     0. back");
            System.out.print("\n     Choose an option: ");
            int option = in.nextInt();

            if (option == 1) {
                addPatient();
                menu();
            }
            if (option == 2) {
                addCommunityDoctor();
                menu();
            }
            if (option == 3) {
                addHospitalDoctor();
                menu();
            }
            if (option == 4) {
                addDiagnosis();
                menu();
            }
            if (option == 5) {
                addMedication();
                menu();
            }
            if (option == 6) {
                addSurgery();
                menu();
            }
            if (option == 0) menu();
        }
        if (option1 == 2) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Main.template();
            System.out.println("     1. Show Patient\n" +
                    "     2. Show Community Doctor\n" +
                    "     3. Show Hospital Doctor\n" +
                    "     4. Show Diagnosis\n" +
                    "     5. Show Medication\n" +
                    "     6. Show Surgery\n\n" +
                    "     0. Back");
            System.out.print("\n     Choose a option: ");
            int option = in.nextInt();

            if (option == 1) {
                Main.template();
                if (Patient.showPatient() != 0) {
                    menu();
                } else {
                    System.out.println("No patient here");
                }
            }
            if (option == 2) {
                Main.template();
                if (CommunityDoctor.showCommunityDoctor() != 0) {
                    menu();
                } else {
                    System.out.println("No community doctor here");
                }
            }

            if (option == 3) {
                Main.template();
                if (HospitalDoctor.showHospitalDoctor() != 0) {
                    menu();
                } else {
                    System.out.println("No hospital doctor here");
                }
            }

            if (option == 4) {
                Main.template();
                if (Diagnosis.showDiagnosis() != 0) {
                    menu();
                } else {
                    System.out.println("No diagnosis here");
                }
            }
            if (option == 5) {
                Main.template();
                if (Medication.showMedication() != 0) {
                    menu();
                } else {
                    System.out.println("No Medication here");
                }
            }
            if (option == 6) {
                Main.template();
                if (Surgery.showSurgery() != 0) {
                    menu();
                } else {
                    System.out.println("No surgery here");
                }
            }
            if (option == 0) menu();
        }
        if (option1 == 0) Main.menu();
    }


    public void addPatient() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter patient's name: ");
        String name = in.nextLine();
        System.out.print("\nEnter patient's address: ");
        String address = in.nextLine();
        System.out.print("\nEnter patient's dateOfBirth: ");
        String dateOfBirth = in.nextLine();
        System.out.print("\nEnter patient's number: ");
        String patientNumber = in.nextLine();
        Patient.patient.add(new Patient(name, address, dateOfBirth, patientNumber));
        System.out.println("Patient added successfully");

    }

    public void addCommunityDoctor() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter community doctor's name: ");
        String name = in.nextLine();
        System.out.print("\nEnter community doctor's speciality: ");
        String specialist = in.nextLine();
        System.out.print("\nEnter community doctor's telephone number: ");
        String telephoneNumber = in.nextLine();

        CommunityDoctor.communityDoctor.add(new CommunityDoctor(name, specialist, telephoneNumber));
        System.out.println("Community Doctor added successfully");

    }

    public void addHospitalDoctor() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter hospital doctor's name: ");
        String name = in.nextLine();
        System.out.print("Enter hospital doctor's speciality: ");
        String specialist = in.nextLine();
        System.out.print("Enter hospital doctor's telephone number: ");
        String telephoneNumber = in.nextLine();

        HospitalDoctor.hospitalDoctor.add(new HospitalDoctor(name, specialist, telephoneNumber));
        System.out.println("Hospital Doctor added successfully");

    }

    public void addDiagnosis() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter diagnosis title: ");
        String description = in.nextLine();
        Diagnosis.diagnosis.add(new Diagnosis(description));
        System.out.println("Diagnosis added successfully");
    }

    public void addMedication() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter drug name: ");
        String drugName = in.nextLine();
        Medication.medication.add(new Medication(drugName));
        System.out.println("Medication added successfully");
    }

    public void addSurgery() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter surgery name: ");
        String surgeryName = in.nextLine();
        Surgery.surgery.add(new Surgery(surgeryName));
        System.out.println("Surgery added successfully");
    }
}
