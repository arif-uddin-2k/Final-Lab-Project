package hospitalDoctorModule;

import java.util.ArrayList;

public class Surgery {
    private  int surgeryCode;
    private String surgeryName;

    public static int code = 0;
    public static ArrayList<Surgery> surgery = new ArrayList<Surgery>();

    public Surgery(String surgeryName) {
        this.surgeryCode = code;
        this.surgeryName = surgeryName;
        code++;
    }

    public static int showSurgery(){
        //Main.clearScreen();
        int cnt = 0;
        System.out.println("\n     Surgery list: (SurgeryCode, SurgeryTitle)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        for(Surgery i : surgery){
            cnt++;
            System.out.println("    |  " + i.getSurgeryCode()+ "  |  " + i.getSurgeryName()+ "  |  ");
        }
        return cnt;
    }
    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public int getSurgeryCode() {
        return surgeryCode;
    }

    public void setSurgeryCode(int surgeryCode) {
        this.surgeryCode = surgeryCode;
    }
}
