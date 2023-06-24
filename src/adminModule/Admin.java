package adminModule;

import hospitalDoctorModule.*;
import patientModule.*;
import communityDoctorModule.*;
import mainModule.*;

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
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("     1. Add\n" +
                "     2. Show\n\n" +
                "     0. Logout");
        System.out.print("\n     Choose an option: ");
        int option1 = sc.nextInt();
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
            int option = sc.nextInt();

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
            Main.template();
            System.out.println("     1. Show Patient\n" +
                    "     2. Show Community Doctor\n" +
                    "     3. Show Hospital Doctor\n" +
                    "     4. Show Diagnosis\n" +
                    "     5. Show Medication\n" +
                    "     6. Show Surgery\n\n" +
                    "     0. Back");
            System.out.print("\n     Choose a option: ");
            int option = sc.nextInt();

            if (option == 1) {
                
                if (Patient.showPatient() != 0) {
                    menu();
                } 
                else {
                    System.out.println("No patient here");
                }
            }
            if (option == 2) {
                
                if (CommunityDoctor.showCommunityDoctor() != 0) {
                    menu();
                } 
                else {
                    System.out.println("No community doctor here");
                }
            }

            if (option == 3) {
                
                if (HospitalDoctor.showHospitalDoctor() != 0) {
                    menu();
                } 
                else {
                    System.out.println("No hospital doctor here");
                }
            }

            if (option == 4) {
               
                if (Diagnosis.showDiagnosis() != 0) {
                    menu();
                } 
                else {
                    System.out.println("No diagnosis here");
                }
            }
            if (option == 5) {
               
                if (Medication.showMedication() != 0) {
                    menu();
                } 
                else {
                    System.out.println("No Medication here");
                }
            }
            if (option == 6) {
                
                if (Surgery.showSurgery() != 0) {
                    menu();
                } 
                else {
                    System.out.println("No surgery here");
                }
            }
            if (option == 0) menu();
        }
        if (option1 == 0) Main.menu();
    }


    public void addPatient() {
        Main.clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter patient's name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter patient's address: ");
        String address = sc.nextLine();
        System.out.print("\nEnter patient's dateOfBirth: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("\nEnter patient's number: ");
        String patientNumber = sc.nextLine();
        Patient.patient.add(new Patient(name, address, dateOfBirth, patientNumber));
        System.out.println("Patient added successfully");

    }

    public void addCommunityDoctor() {
        Main.clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter community doctor's name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter community doctor's speciality: ");
        String specialist = sc.nextLine();
        System.out.print("\nEnter community doctor's telephone number: ");
        String telephoneNumber = sc.nextLine();

        CommunityDoctor.communityDoctor.add(new CommunityDoctor(name, specialist, telephoneNumber));
        System.out.println("Community Doctor added successfully");

    }

    public void addHospitalDoctor() {
        Main.clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hospital doctor's name: ");
        String name = sc.nextLine();
        System.out.print("Enter hospital doctor's speciality: ");
        String specialist = sc.nextLine();
        System.out.print("Enter hospital doctor's telephone number: ");
        String telephoneNumber = sc.nextLine();

        HospitalDoctor.hospitalDoctor.add(new HospitalDoctor(name, specialist, telephoneNumber));
        System.out.println("Hospital Doctor added successfully");

    }

    public void addDiagnosis() {
        Main.clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter diagnosis title: ");
        String description = sc.nextLine();
        Diagnosis.diagnosis.add(new Diagnosis(description));
        System.out.println("Diagnosis added successfully");
    }

    public void addMedication() {
        Main.clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter drug name: ");
        String drugName = sc.nextLine();
        Medication.medication.add(new Medication(drugName));
        System.out.println("Medication added successfully");
    }

    public void addSurgery() {
        Main.clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter surgery name: ");
        String surgeryName = sc.nextLine();
        Surgery.surgery.add(new Surgery(surgeryName));
        System.out.println("Surgery added successfully");
    }
}
