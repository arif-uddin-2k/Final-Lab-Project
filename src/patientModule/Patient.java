package patientModule;

import mainModule.*;
import hospitalDoctorModule.*;

import java.util.ArrayList;
import java.util.Date;

public class Patient {

    private int patientId;
    private String name;
    private String address;
    private String dateOfBirth;
    private String patientNumber;
    private String reasonForAdmission, reasonForDischarge;
    private Date dateOfAdmission, dateOfDischarge;
    private String status;

    private Diagnosis diagnosis;
    private HospitalDoctor hospitalDoctor;
    private PatientInfo patientInfo;

    public static int id = 0;
    public static ArrayList<Patient> patient = new ArrayList<>();

    public Patient(){

    }

    public Patient(String name, String address, String dateOfBirth, String patientNumber) {
        this.patientId = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.patientNumber = patientNumber;
        this.status = "newPatient";
        id++;
    }

    public static int showAllPatient() {
        int cnt = 0;
        System.out.println("\n     Patients list: (PatientId, Name, Address, DateOfBirth, Number)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Patient i: patient) {
            cnt++;
            System.out.println("    |  " + i.getPatientId() + "  |  " + i.getName() + "  |  " + i.getAddress() + "  |  " + i.getDateOfBirth() + "  |  "
                    + i.getPatientNumber() + "  |  ");
        }
        return cnt;
    }

    public static int showPatient(){

        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Patients list: (PatientId, Name, Address, DateOfBirth, Number)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Patient i: patient) {
            if (i.getStatus() == "newPatient") {
                cnt++;
                System.out.println("    |  " + i.getPatientId() + "  |  " + i.getName() + "  |  " + i.getAddress() + "  |  " + i.getDateOfBirth() + "  |  "
                        + i.getPatientNumber() + "  |  ");
            }
        }
        return cnt;
    }

    public static int showActivePatient(){
        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Active patient list:(PatientId, Name, Address, DateOfBirth, Number, ReasonForAdmission, DateOfAdmission)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Patient i: patient){
            if(i.getStatus() == "Active") {
                cnt++;
                System.out.println("    |  " + i.getPatientId() + "  |  " + i.getName() + "  |  " + i.getAddress() + "  |  " + i.getDateOfBirth()
                        + "  |  " + i.getPatientNumber() + "  |  " + i.getReasonForAdmission() + "  |  " + i.getDateOfAdmission());
            }
        }
        return cnt;
    }
    public static int showTreatablePatient(){
        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Treatable patient list:(PatientId, Name, Address, DateOfBirth, Number, ReasonForAdmission, DiagnosisTitle, DateOfAdmission)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Patient i: patient){
            if(i.getStatus() == "Treatable") {
                cnt++;
                System.out.println("    |  " + i.getPatientId() + "  |  " + i.getName() + "  |  " + i.getAddress() + "  |  " + i.getDateOfBirth()
                        + "  |  " + i.getPatientNumber() + "  |  " + i.getReasonForAdmission() + "  |  " + i.getDiagnosis().getDescription() + "  |  "
                        + i.getDateOfAdmission());
            }
        }
        return cnt;
    }

    public static int showTreatedPatient(){

        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Treated patient list: (PatientId, Name, Address, DateOfBirth, Number)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
        for(Patient i: patient){
            if(i.getStatus() == "Treated") {
                cnt++;
                System.out.println("     |  " + i.getPatientId() + "  |  " + i.getName() + "  |  " + i.getAddress() + "  |  " + i.getDateOfBirth()
                        + "  |  " + i.getPatientNumber());
            }
        }
        return cnt;
    }

    public static String providePrescription(int index){

        Patient i = Patient.patient.get(index);
        return  "-----------------------------------------------------------------------------------------------------------------------------------------\n" +
                "                                                        EverCare Hospital Limited                                                        \n" +
                "                                                         (Patient Prescription )                                                         \n" +
                "-----------------------------------------------------------------------------------------------------------------------------------------\n" +

                "     Patient Id           : " + i.getPatientId() +      "                          " + "Admitted Reason: " + i.getReasonForAdmission() + "         \n" +
                "     Patient Name         : " + i.getName()+            "                          " + "Admitted Date:                                             \n" +
                "     Patient Address      : " + i.getAddress() +        "                          " +  i.getDateOfAdmission() + "                                 \n" +
                "     Patient DateOfBirth  : " + i.getDateOfBirth() +    "                          " + "Discharge Reason: " + i.getReasonForDischarge() + "        \n" +
                "     Patient Number       : " + i.getPatientNumber() +  "                          " + "Discharge Date:                                            \n" +
                "                                                    " + "                          " + i.getDateOfDischarge() + "                                  \n" +
                "     Given diagnosis: \n" +
                "         " + i.getDiagnosis().getDescription() + "\n" +

        (i.getHospitalDoctor().getMedication() != null ?
                "     Given medication:\n" +
                "         " + i.getHospitalDoctor().getMedication().getDrugName() : "\n") +

        (i.getHospitalDoctor().getSurgery() != null ?
            "\n     Given surgery:" +
            "\n         " + i.getHospitalDoctor().getSurgery().getSurgeryName() : "\n") +

            "\n     Prescribed by:" +
            "\n         " + i.getHospitalDoctor().getName() +
            "\n         " + i.getHospitalDoctor().getSpecialist() +
            "\n         " + i.getHospitalDoctor().getTelephoneNumber() +
            "\n-----------------------------------------------------------------------------------------------------------------------------------------\n";
        }
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonForAdmission() {
        return reasonForAdmission;
    }

    public void setReasonForAdmission(String reasonForAdmission) {
        this.reasonForAdmission = reasonForAdmission;
    }

    public String getReasonForDischarge() {
        return reasonForDischarge;
    }

    public void setReasonForDischarge(String reasonForDischarge) {
        this.reasonForDischarge = reasonForDischarge;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Date getDateOfDischarge() {
        return dateOfDischarge;
    }

    public void setDateOfDischarge(Date dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public HospitalDoctor getHospitalDoctor() {
        return hospitalDoctor;
    }

    public void setHospitalDoctor(HospitalDoctor hospitalDoctor) {
        this.hospitalDoctor = hospitalDoctor;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }
}
