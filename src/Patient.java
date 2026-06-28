public class Patient extends Person
{
    private String disease;
    private String ward;
    private int assignedRoom;
    private int assignedBed;



    Patient(String name, int age, String disease,String ward)
    {
        super(name,age);
        this.disease=disease;

        this.ward=ward;

    }

    Patient(String id, String name, int age, String disease,String ward)
    {
        super(id,name,age);
        this.disease=disease;
        this.ward=ward;
    }

    Patient(String name, int age, String disease, String ward, int assignedRoom, int assignedBed)
    {
        super(name,age);
        this.disease=disease;
        this.ward=ward;
        this.assignedRoom=assignedRoom;
        this.assignedBed=assignedBed;
    }

    Patient(String id, String name, int age, String disease, String ward, int assignedRoom, int assignedBed)
    {
        super(id,name,age);
        this.disease=disease;
        this.ward=ward;
        this.assignedRoom=assignedRoom;
        this.assignedBed=assignedBed;
    }

    public static Ward medical= new Medical(10,20);
    public static Ward gynecology = new Gynecology(9,18);
    public static Ward children = new Children(12,24);
    public static Ward heart = new Heart(5,10);

    public void assignBedRoom()
    {
        Ward selectedWard = getSelectedWard();
        if(selectedWard == null)
        {
            return;
        }

        if(selectedWard.assignBedRoom())
        {
            assignedRoom = selectedWard.getAssignedRoom();
            assignedBed = selectedWard.getAssignedBed();
        }
    }

    public int getAssignedRoom()
    {
        return assignedRoom;
    }

    public int getAssignedBed()
    {
        return assignedBed;
    }

    public void removeRoom(String ward)
    {
        Ward selectedWard = getSelectedWard();
        if(selectedWard == null)
        {
            return;
        }

        int bedIndex = ((assignedRoom - 1) * 2) + assignedBed;
        selectedWard.removeBed(bedIndex);
        assignedRoom = 0;
        assignedBed = 0;
    }

    public boolean restoreAssignedBed()
    {
        Ward selectedWard = getSelectedWard();
        if(selectedWard == null)
        {
            return false;
        }

        return selectedWard.occupyBed(assignedRoom, assignedBed);
    }

    private Ward getSelectedWard()
    {
        if(this.ward.equalsIgnoreCase("medical"))
        {
            return medical;
        }
        else if(this.ward.equalsIgnoreCase("children"))
        {
            return children;
        }
        else if(this.ward.equalsIgnoreCase("heart"))
        {
            return heart;
        }
        else if(this.ward.equalsIgnoreCase("gynecology"))
        {
            return gynecology;
        }
        else
        {
            return null;
        }
    }



    public String getWard() {
        return ward;
    }

    public void setWard(String  ward) {
        this.ward = ward;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
