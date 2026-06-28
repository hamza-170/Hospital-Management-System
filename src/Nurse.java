public class Nurse extends Person
{
    private int shiftHours;
    Nurse(String name,int age,int shiftHours)
    {
        super(name,age);
        this.shiftHours=shiftHours;
    }

    Nurse(String id,String name,int age,int shiftHours)
    {
        super(id,name,age);
        this.shiftHours=shiftHours;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }

    public int getShiftHours() {
        return shiftHours;
    }
}
