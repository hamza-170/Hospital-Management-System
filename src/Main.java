
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main
{

    public static void main(String [] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        AddPerson addPerson = new AddPerson();
        addPerson.loadDoctorObjects();
        addPerson.loadNurseObjects();
        addPerson.loadPatientObjects();
        addPerson.loadStaffObjects();

        while(true)
        {
            System.out.println("\n\n------------Menu------------");
            System.out.println("1. Add Doctor/Staff/Nurse");
            System.out.println("2. Add Patient to Ward, room and bed");
            System.out.println("3. Display Ward, Room, Bed Details");
            System.out.println("4. View Patient records");
            System.out.println("5. View Doctor/Staff/Nurse records");
            System.out.println("6. Remove Person");
            System.out.println("7. Exit");
            System.out.print("Choose(1-7): ");
            int choice = input.nextInt();


            if(choice==1) {
                while(true)
                {
                    System.out.println("\n\n1. Add Doctor");
                    System.out.println("2. Add Nurse");
                    System.out.println("3. Add Staff");
                    System.out.println("4. Exit");
                    System.out.print("Choose(1-4): ");

                    int add = input.nextInt();
                    if (add == 1)
                    {
                        System.out.print("Enter name: ");
                        input.nextLine(); // buffer clear
                        String name = input.nextLine();

                        System.out.print("Enter age: ");
                        int age = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter Speciality: ");
                        String speciality = input.nextLine();

                        addPerson.addDoctor(name, age, speciality);



                    }
                    else if (add == 2)
                    {
                        System.out.print("Enter name: ");
                        input.nextLine(); // buffer clear
                        String name = input.nextLine();

                        System.out.print("Enter age: ");
                        int age = input.nextInt();

                        System.out.print("Enter shift hours: ");
                        int shiftHours = input.nextInt();



                        addPerson.addNurse(name,age,shiftHours);
                    }
                    else if (add == 3)
                    {
                        System.out.print("Enter name: ");
                        input.nextLine(); // buffer clear
                        String name = input.nextLine();

                        System.out.print("Enter age: ");
                        int age = input.nextInt();

                        System.out.print("Enter Shift Hours: ");
                        int shiftHours = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter Role: ");
                        String role = input.nextLine();

                        addPerson.addStaff(name, age, shiftHours, role);
                    }
                    else if (add == 4)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Choose appropriate option.\n\n");
                    }
                }
            }
            else if(choice==2)
            {
                System.out.print("Enter patient name: ");
                input.nextLine();
                String name = input.nextLine();

                System.out.print("Enter age: ");
                int age = input.nextInt();
                input.nextLine();

                System.out.print("Enter Disease: ");
                String disease = input.nextLine();

                System.out.print("Enter Ward: ");
                String ward = input.nextLine();

                addPerson.addPatient(name,age,disease,ward);


            }
            else if (choice==3)
            {
                while(true)
                {
                    System.out.println("\n\n------------Ward Details------------");
                    System.out.println("1. Medical Ward Details");
                    System.out.println("2. Children Ward Details");
                    System.out.println("3. Heart Ward Details");
                    System.out.println("4. Gynecology Ward Details");
                    System.out.println("5. Exit");
                    System.out.print("Choose(1-5): ");

                    int wardChoice = input.nextInt();
                    if(wardChoice == 1)
                    {
                        addPerson.displayMedicalWardDetails();
                    }
                    else if(wardChoice == 2)
                    {
                        addPerson.displayChildrenWardDetails();
                    }
                    else if(wardChoice == 3)
                    {
                        addPerson.displayHeartWardDetails();
                    }
                    else if(wardChoice == 4)
                    {
                        addPerson.displayGynecologyWardDetails();
                    }
                    else if(wardChoice == 5)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Choose appropriate option.\n\n");
                    }
                }
            }
            else if(choice==4)
            {
                new ReadFile().patientFile();
            }
            else if(choice==5)
            {
                while(true)
                {
                    System.out.println("\n\n1. View Doctor");
                    System.out.println("2. View Nurse");
                    System.out.println("3. View Staff");
                    System.out.println("4. Exit");
                    System.out.print("Choose(1-4): ");
                    int choose = input.nextInt();
                    if (choose == 1) {
                        new ReadFile().doctorFile();
                    } else if (choose == 2) {
                        new ReadFile().nurseFile();
                    } else if (choose == 3) {
                        new ReadFile().staffFile();
                    } else if (choose == 4) {
                        break;
                    } else {
                        System.out.println("Choose appropriate option.");
                    }
                }
            }
            else if(choice==6)
            {
                while(true)
                {
                    System.out.println("\n\n1. Remove Doctor");
                    System.out.println("2. Remove Nurse");
                    System.out.println("3. Remove Staff");
                    System.out.println("4. Remove Patient");
                    System.out.println("5. Exit");
                    System.out.print("Choose(1-5): ");
                    int removeChoice = input.nextInt();

                    if(removeChoice == 5)
                    {
                        break;
                    }

                    System.out.print("Enter ID: ");
                    input.nextLine();
                    String id = input.nextLine();

                    if(removeChoice == 1)
                    {
                        addPerson.removeDoctor(id);
                    }
                    else if(removeChoice == 2)
                    {
                        addPerson.removeNurse(id);
                    }
                    else if(removeChoice == 3)
                    {
                        addPerson.removeStaff(id);
                    }
                    else if(removeChoice == 4)
                    {
                        addPerson.removePatient(id);
                    }
                    else
                    {
                        System.out.println("Choose appropriate option.");
                    }
                }
            }
            else if (choice ==7)
            {
                break;

            } else
            {
                System.out.println("Choose appropriate option.\n\n");
                continue;
            }

        }


    }
}
