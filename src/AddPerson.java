import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddPerson
{
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Staff> staff = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Nurse> nurses = new ArrayList<>();

    UpdateFile update = new UpdateFile();
    private int nextDoctorId = 1;
    private int nextStaffId = 1;
    private int nextNurseId = 1;
    private int nextPatientId = 1;

    public void addDoctor(String name, int age, String speciality)
    {
        doctors.add(new Doctor("D" + nextDoctorId,name,age,speciality));
        nextDoctorId++;
        update.updateDoctor(doctors);
    }

    public void addNurse(String name, int age,  int shiftHours)
    {
        nurses.add(new Nurse("N" + nextNurseId,name,age,shiftHours));
        nextNurseId++;
        update.updateNurse(nurses);
    }

    public void addStaff(String name, int age, int shiftHours,String role)
    {
        staff.add(new Staff("S" + nextStaffId,name,age,shiftHours, role));
        nextStaffId++;
        update.updateStaff(staff);
    }
    public void addPatient(String name, int age, String disease,String ward)
    {
        Patient p = new Patient("P" + nextPatientId,name,age,disease,ward);
        nextPatientId++;
        p.assignBedRoom();
        patients.add(p);

        update.updatePatient(patients);
    }

    public void removeDoctor(String id)
    {
        for(int i = 0; i < doctors.size(); i++)
        {
            if(doctors.get(i).getId().equalsIgnoreCase(id))
            {
                doctors.remove(i);
                update.updateDoctor(doctors);
                System.out.println("Doctor removed.");
                return;
            }
        }
        System.out.println("Doctor id not found.");
    }

    public void removeNurse(String id)
    {
        for(int i = 0; i < nurses.size(); i++)
        {
            if(nurses.get(i).getId().equalsIgnoreCase(id))
            {
                nurses.remove(i);
                update.updateNurse(nurses);
                System.out.println("Nurse removed.");
                return;
            }
        }
        System.out.println("Nurse id not found.");
    }

    public void removeStaff(String id)
    {
        for(int i = 0; i < staff.size(); i++)
        {
            if(staff.get(i).getId().equalsIgnoreCase(id))
            {
                staff.remove(i);
                update.updateStaff(staff);
                System.out.println("Staff removed.");
                return;
            }
        }
        System.out.println("Staff id not found.");
    }

    public void removePatient(String id)
    {
        for(int i = 0; i < patients.size(); i++)
        {
            if(patients.get(i).getId().equalsIgnoreCase(id))
            {
                patients.get(i).removeRoom(patients.get(i).getWard());
                patients.remove(i);
                Patient.medical = new Medical(10,20);
                Patient.gynecology = new Gynecology(9,18);
                Patient.children = new Children(12,24);
                Patient.heart = new Heart(5,10);
                for(int j = 0; j < patients.size(); j++)
                {
                    patients.get(j).assignBedRoom();
                }
                update.updatePatient(patients);
                System.out.println("Patient removed.");
                return;
            }
        }
        System.out.println("Patient id not found.");
    }

    public void displayMedicalWardDetails()
    {
        Patient.medical.displayDetails("Medical");
    }

    public void displayChildrenWardDetails()
    {
        Patient.children.displayDetails("Children");
    }

    public void displayHeartWardDetails()
    {
        Patient.heart.displayDetails("Heart");
    }

    public void displayGynecologyWardDetails()
    {
        Patient.gynecology.displayDetails("Gynecology");
    }

    public void loadDoctorObjects() throws FileNotFoundException {
        File file  = new File("doctors.txt");
        if (!file.exists()) return;
        Scanner load = new Scanner(file);

        while(load.hasNext())
        {
            String line = load.nextLine();

            String[] data = line.split(",");

            if(data[0].matches("D\\d+"))
            {
                doctors.add(new Doctor(data[0],data[1],Integer.parseInt(data[2]),data[3]));
                nextDoctorId = Math.max(nextDoctorId, Integer.parseInt(data[0].substring(1)) + 1);
            }
            else
            {
                doctors.add(new Doctor("D" + nextDoctorId,data[0],Integer.parseInt(data[1]),data[2]));
                nextDoctorId++;
            }

        }
        update.updateDoctor(doctors);

    }

    public void loadNurseObjects() throws FileNotFoundException {
        File file  = new File("nurses.txt");
        if (!file.exists()) return;
        Scanner load = new Scanner(file);

        while(load.hasNext())
        {
            String line = load.nextLine();

            String[] data = line.split(",");

            if(data[0].matches("N\\d+"))
            {
                nurses.add(new Nurse(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3])));
                nextNurseId = Math.max(nextNurseId, Integer.parseInt(data[0].substring(1)) + 1);
            }
            else
            {
                nurses.add(new Nurse("N" + nextNurseId,data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
                nextNurseId++;
            }

        }
        update.updateNurse(nurses);

    }

    public void loadStaffObjects() throws FileNotFoundException {
        File file  = new File("staff.txt");
        if (!file.exists()) return;
        Scanner load = new Scanner(file);


        while(load.hasNext())
        {
            String line = load.nextLine();

            String[] data = line.split(",");

            if(data[0].matches("S\\d+"))
            {
                staff.add(new Staff(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4]));
                nextStaffId = Math.max(nextStaffId, Integer.parseInt(data[0].substring(1)) + 1);
            }
            else
            {
                staff.add(new Staff("S" + nextStaffId,data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3]));
                nextStaffId++;
            }

        }
        update.updateStaff(staff);

    }

    public void loadPatientObjects() throws FileNotFoundException {
        File file  = new File("patient.txt");
        if (!file.exists()) return;
        Scanner load = new Scanner(file);

        while(load.hasNext())
        {
            String line = load.nextLine();

            String[] data = line.split(",");

            Patient p;
            if(data[0].matches("P\\d+"))
            {
                p = new Patient(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4]);
                nextPatientId = Math.max(nextPatientId, Integer.parseInt(data[0].substring(1)) + 1);
            }
            else
            {
                p = new Patient("P" + nextPatientId,data[0],Integer.parseInt(data[1]),data[2],data[3]);
                nextPatientId++;
            }
            p.assignBedRoom();
            patients.add(p);

        }

        update.updatePatient(patients);

    }


}
