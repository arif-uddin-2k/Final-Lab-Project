package hospitalDoctorModule;

import mainModule.*;

import java.util.ArrayList;

public class Diagnosis {
    private int diagnosisCode;
    private String description;

    public static int code = 0;
    public static ArrayList<Diagnosis> diagnosis = new ArrayList<Diagnosis>();

    public Diagnosis(){

    }
    public Diagnosis(String description){
        this.diagnosisCode = code;
        this.description = description;
        code++;
    }

    public static int showDiagnosis(){

        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Diagnosis list: (DiagnosisCode, DiagnosisTitle)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Diagnosis i : diagnosis){
            cnt++;
            System.out.println("    |  " + i.getDiagnosisCode()+ "  |  " + i.getDescription() + "  |  ");
        }
        return cnt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(int diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }
}
