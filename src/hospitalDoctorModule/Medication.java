package hospitalDoctorModule;

import mainModule.*;

import java.util.ArrayList;

public class Medication {
    private int drugCode;
    private String drugName;

    public static int code = 0;
    public static ArrayList<Medication> medication = new ArrayList<Medication>();

    public Medication(){

    }
    public Medication(String drugName) {
        this.drugCode = code;
        this.drugName = drugName;
        code++;
    }

    public static int showMedication(){

        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Medication list: (DrugId, DrugName)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Medication i : medication){
            cnt++;
            System.out.println("    |  " + i.getDrugCode()+ "  |  " + i.getDrugName() + "  |  ");
        }
        return cnt;
    }
    public void setMedication(){

    }
    public int getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(int drugCode) {
        this.drugCode = drugCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}
