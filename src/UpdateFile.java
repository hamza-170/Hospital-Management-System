import java.io.PrintWriter;
import java.util.ArrayList;

public class UpdateFile
{
    public void updateDoctor(ArrayList<Doctor> doctors)
    {
        try(PrintWriter output = new PrintWriter("doctors.txt"))
        {
            for(int i=0;i<doctors.size();i++)
            {

                    output.println(doctors.get(i).getId()+","+doctors.get(i).getName()+","+doctors.get(i).getAge()+","+doctors.get(i).getSpeciality());


            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    public void updateNurse(ArrayList<Nurse> nurses)
    {
        try(PrintWriter output = new PrintWriter("nurses.txt"))
        {
            for(int i=0;i<nurses.size();i++)
            {

                    output.println(nurses.get(i).getId()+","+nurses.get(i).getName()+","+nurses.get(i).getAge()+","+nurses.get(i).getShiftHours());

            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    public void updateStaff(ArrayList<Staff> staff)
    {
        try(PrintWriter output = new PrintWriter("staff.txt"))
        {
            for(int i=0;i<staff.size();i++)
            {

                    output.println(staff.get(i).getId()+","+staff.get(i).getName()+","+staff.get(i).getAge()+","+staff.get(i).getShiftHours()+","+staff.get(i).getRole());

            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    public void updatePatient(ArrayList<Patient> patient)
    {
        try(PrintWriter output = new PrintWriter("patient.txt"))
        {
            for(int i=0;i<patient.size();i++)
            {
                    output.println(patient.get(i).getId()+","+patient.get(i).getName()+","+patient.get(i).getAge()+","+patient.get(i).getDisease()+","+patient.get(i).getWard()+","+patient.get(i).getAssignedRoom()+","+patient.get(i).getAssignedBed());
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

}
