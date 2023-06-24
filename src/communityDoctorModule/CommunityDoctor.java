package communityDoctorModule;

import mainModule.*;
import hospitalDoctorModule.*;
import patientModule.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CommunityDoctor {
    private int doctorId;
    private String name;
    private String specialist;
    private String telephoneNumber;

    private HospitalDoctor hospitalDoctor;

    public static int id = 0;
    public static ArrayList<CommunityDoctor> communityDoctor = new ArrayList<CommunityDoctor>();
    public CommunityDoctor(){

    }

    public CommunityDoctor(String name, String specialist, String telephoneNumber) {
        this.doctorId = id;
        this.name = name;
        this.specialist = specialist;
        this.telephoneNumber = telephoneNumber;
        id++;
    }

    public void menu(){
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        Main.template();
        System.out.println("     1. Refer A Patient\n" +
                           "     2. Discharge A Patient\n\n" +
                           "     0. Logout");
        System.out.print("\n     Choose an option: ");
        int option = in.nextInt();
        if(option == 1) {
            referPatient();
            menu();
        }
        if(option == 2){
            dischargePatient();
            menu();
        }
        if(option == 0){
            Main.menu();
        }
    }
    public static int showCommunityDoctor(){

        Main.template();
        int cnt = 0;
        System.out.println("\n    Community doctor list: (DoctorId, Name, Specialist, Number)");
        for(CommunityDoctor i : communityDoctor){
            cnt++;
            System.out.println(i.getDoctorId() + "     |  " + i.getName()+ "  |  " + i.getSpecialist() + "  |  " + i.getTelephoneNumber() + "  |  ");
        }
        return cnt;
    }

    public void referPatient(){
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        if(Patient.showPatient() != 0) {
            System.out.print("\n     Enter 'patientId' for refer: ");
            int index = in.nextInt();
            Patient patient = Patient.patient.get(index);
            System.out.print("\n     Enter reason for admission: ");
            String reason = in.next();
            patient.setReasonForAdmission(reason);
            patient.setStatus("Active");
            patient.setDateOfAdmission(new Date());
            HospitalDoctor.showHospitalDoctor();
            System.out.print("\n     Enter hospital 'DoctorId' to refer: ");
            int index2 = in.nextInt();
            patient.setHospitalDoctor(HospitalDoctor.hospitalDoctor.get(index2));
            System.out.println("\n     Patient refers to hospital doctor successfully.");
        }
        else{
            System.out.println("     No referable patient here");
        }
    }

    public void dischargePatient(){
        Main.clearScreen();
        Scanner in = new Scanner(System.in);
        if(Patient.showTreatedPatient() != 0) {
            System.out.print("\n     Enter 'PatientId' for Discharge: ");
            int index = in.nextInt();
            Patient patient = Patient.patient.get(index);
            System.out.print("\n     Enter reason for discharge: ");
            String reason = in.next();
            patient.setReasonForDischarge(reason);
            patient.setDateOfDischarge(new Date());
            patient.setStatus("dischhargeed");
            PatientInfo.patientInfo(index);
        }
        else{
            System.out.println("     No dischargable patient here");
        }
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public HospitalDoctor getHospitalDoctor() {
        return hospitalDoctor;
    }

    public void setHospitalDoctor(HospitalDoctor hospitalDoctor) {
        this.hospitalDoctor = hospitalDoctor;
    }
}
