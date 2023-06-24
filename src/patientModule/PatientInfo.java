package outModule;

import mainModule.Patient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PatientInfo {

    public static void patientInfo(int index){

        File file = new File("patientInfo.txt");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(Patient.providePrescription(index));
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        try {
            Scanner reader = new Scanner(file);
            System.out.println("Patient File: ");
            while(reader.hasNext()) {
                String content = reader.nextLine();
                System.out.println(content);
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }
}
