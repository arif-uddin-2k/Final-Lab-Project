package mainModule;

import outModule.Main;
import subModule.Diagnosis;
import subModule.Medication;
import subModule.Surgery;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalDoctor {
    private int doctorId;
    private String name;
    private String specialist;
    private String telephoneNumber;

    private Patient patient;
    private Medication medication;
    private Surgery surgery;

    public  static int id = 0;
    public static ArrayList<HospitalDoctor> hospitalDoctor = new ArrayList<HospitalDoctor>();

    public HospitalDoctor(){

    }

    public HospitalDoctor(String name, String specialist, String telephoneNumber) {
        this.doctorId = id;
        this.name = name;
        this.specialist = specialist;
        this.telephoneNumber = telephoneNumber;
        id++;
    }

    public void menu(){
        Main.clearScreen();
        Scanner in =new Scanner(System.in);
        Main.template();
        System.out.println("     1. Make Treatment\n" +
                           "     2. Suggest Diagnosis\n\n"+
                           "     0. Logout");
        System.out.print("\n     Choose an option: ");
        int option = in.nextInt();
        if(option == 1) {
            makeTreatment();
            menu();
        }
        if(option == 2){
            suggestDiagnosis();
            menu();
        }
        if(option == 0) {
            Main.menu();
        }
    }
    public void makeTreatment() {
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        if(Patient.showTreatablePatient() != 0) {
            System.out.print("\n     Choose a patient to treatment: ");
            int index = in.nextInt();
            Patient patient = Patient.patient.get(index);

            int close = 1;
            while (close == 1) {
                Main.clearScreen();
                System.out.println("\n     Treatment options: ");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("        1. Medication\n" + "        2. Surgery" + "\n" + "        3. Complete treatment");
                System.out.print("\n     Choose an option: ");
                int option = in.nextInt();
                if (option == 1) {
                    Medication.showMedication();
                    System.out.print("\n     Enter MedicationCode: ");
                    int index1 = in.nextInt();

                    patient.getHospitalDoctor().setMedication(Medication.medication.get(index1));
                    System.out.println("     Medication given successfully");
                } else if (option == 2) {
                    Surgery.showSurgery();
                    System.out.print("\n     Enter SurgeryCode: ");
                    int index1 = in.nextInt();

                    patient.getHospitalDoctor().setSurgery(Surgery.surgery.get(index1));
                    System.out.println("     Surgery given successfully");
                } else if (option == 3) {
                    patient.setStatus("Treated");
                    System.out.println("     Successfully treatment to the patient");
                    break;
                }
            }
        }
        else{
            System.out.println("     No treatable patient here");
        }
    }

    public void suggestDiagnosis(){
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        if(Patient.showActivePatient() != 0) {
            System.out.print("\n     Enter 'patientId' to set diagnosis: ");
            int index = in.nextInt();
            Patient patient = Patient.patient.get(index);
            patient.setStatus("Treatable");
            Diagnosis.showDiagnosis();
            System.out.print("\n     Choose an DiagnosisCode: ");
            int index1 = in.nextInt();
            patient.setDiagnosis(Diagnosis.diagnosis.get(index1));
            System.out.println("     Diagnosis suggested successfully");
        }
        else{
            System.out.println("     No active patient here");
        }
    }

    public static int showHospitalDoctor(){

        Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Hospital doctor list: (DoctorId, Name, Specialist, Number)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(HospitalDoctor i : hospitalDoctor){
            cnt++;
            System.out.println("    |  " + i.getDoctorId() + "  |  " + i.getName()+ "  |  " + i.getSpecialist() + "  |  " + i.getTelephoneNumber() + "  |  ");
        }
        return cnt;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }
}
