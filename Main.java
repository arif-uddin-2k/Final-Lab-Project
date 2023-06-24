package outModule;

import mainModule.*;
import subModule.*;
import java.util.Scanner;

public class Main {
    public static void clearScreen() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.flush();
    }

    public static void template(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                EverCare Hospital Limited System");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
    }
    public static void menu(){
        clearScreen();
        Scanner in = new Scanner(System.in);
        template();
        System.out.println("     1. Login");
        System.out.println("     2. Exit");
        System.out.print("\n     Chose a option: ");
        int option = in.nextInt();
        if(option == 1){
            clearScreen();
            template();
            System.out.println("     Login as:");
            System.out.println("        1. Admin\n" +
                               "        2. Community Doctor\n" +
                               "        3. Hospital Doctor\n");
            System.out.print("     Chose a option: ");
            int option1 = in.nextInt();

            if(option1 == 1){
                Admin admin = new Admin();
                admin.menu();
            }
            if(option1 == 2){

                System.out.print("\n     Enter community doctorId: ");
                int doctorId = in.nextInt();
                CommunityDoctor cd = CommunityDoctor.communityDoctor.get(doctorId);
                cd.menu();
            }
            if(option1 == 3) {
                System.out.print("\n     Enter hospital doctorId: ");
                int doctorId = in.nextInt();
                HospitalDoctor hd = HospitalDoctor.hospitalDoctor.get(doctorId);
                hd.menu();
            }
        }
        if(option == 2){
            clearScreen();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("                                           Thanks for using Ever Care Hospital Limited System");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
    public static void main(String[] args) {

        Patient.patient.add(new Patient("Shafin", "Rajshahi", "04/06/2023", "01762786263"));
        Patient.patient.add(new Patient("Arif", "Rajshahi", "28/05/2023", "01762786263"));

        HospitalDoctor.hospitalDoctor.add(new HospitalDoctor("Moin", "General Sergen", "0394893"));
        HospitalDoctor.hospitalDoctor.add(new HospitalDoctor("Moin", "Neuro Sergen", "01887394893"));

        CommunityDoctor.communityDoctor.add(new CommunityDoctor("Arif", "5017", "01909540465"));

        Diagnosis.diagnosis.add(new Diagnosis("CT Scan"));
        Medication.medication.add(new Medication("Paracitamal"));
        Medication.medication.add(new Medication("Antibiotic"));
        Surgery.surgery.add(new Surgery("General Surjery"));

        Main.menu();
    }
}