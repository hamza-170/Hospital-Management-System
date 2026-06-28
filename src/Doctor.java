import java.util.ArrayList;

public class Doctor extends Person
{
    private String speciality;

    Doctor(String name,int age,String speciality)
    {
        super(name,age);
        this.speciality=speciality;
    }

    Doctor(String id,String name,int age,String speciality)
    {
        super(id,name,age);
        this.speciality=speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


}
