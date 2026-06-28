import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
    public void doctorFile() throws FileNotFoundException
    {
        Scanner read = new Scanner(new File("doctors.txt"));
        for(int i=1;read.hasNext();i++)
        {
            String line= read.nextLine();
            String[] data = line.split(",");
            System.out.println("Doctor: "+i+
                    "\nID: "+data[0]+
                    "\nName: "+data[1]+
                    "\nAge: "+data[2]+
                    "\nSpeciality: "+data[3]+
                    "\n");
        }
    }
    public void staffFile() throws FileNotFoundException
    {
        Scanner read = new Scanner(new File("staff.txt"));
        for(int i=1;read.hasNext();i++)
        {
            String line= read.nextLine();
            String[] data = line.split(",");
            System.out.println("Staff: "+i+
                    "\nID: "+data[0]+
                    "\nName: "+data[1]+
                    "\nAge: "+data[2]+
                    "\nShift Hours: "+data[3]+
                    "\nRole: "+ data[4]+
                    "\n");
        }

    }
    public void patientFile() throws FileNotFoundException {
        try {
            Scanner read = new Scanner(new File("patient.txt"));
            for (int i = 1; read.hasNext(); i++) {
                String line = read.nextLine();
                String[] data = line.split(",");
                System.out.println("Patient: " + i +
                        "\nID: " + data[0] +
                        "\nName: " + data[1] +
                        "\nAge: " + data[2] +
                        "\nDisease: " + data[3] +
                        "\nWard: " + data[4] +
                        "\nRoom: " + data[5] +
                        "\nBed: " + data[6] +
                        "\n\n");
            }
        }
        catch (FileNotFoundException f) {
            System.out.println("File not found.");
        }
    }
    public void nurseFile() throws FileNotFoundException
    {


        Scanner read = new Scanner(new File("nurses.txt"));
        for(int i=1;read.hasNext();i++)
        {
            String line= read.nextLine();
            String[] data = line.split(",");
            System.out.println("Nurse: "+i+
                    "\nID: "+data[0]+
                    "\nName: "+data[1]+
                    "\nAge: "+data[2]+
                    "\nShift Hours: "+data[3]+
                    "\n");
        }
    }

}
