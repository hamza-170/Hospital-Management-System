public class Staff extends Person
{
    private String role;
    private int shiftHours;
    Staff(String name, int age, int shiftHours, String role)
    {
        super(name,age);
        this.role=role;
        this.shiftHours=shiftHours;
    }

    Staff(String id, String name, int age, int shiftHours, String role)
    {
        super(id,name,age);
        this.role=role;
        this.shiftHours=shiftHours;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }

    public String getRole() {
        return role;
    }
}
