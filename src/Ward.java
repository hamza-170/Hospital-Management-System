import java.util.Arrays;

public class Ward
{
    private int rooms;
    private int beds;

    boolean[] availableBed;

    Ward(int rooms, int beds)
    {
        this.beds=beds;
        this.rooms=rooms;

        availableBed = new boolean[rooms * 2];
        Arrays.fill(availableBed, true);
    }
    private int assignedRoom;
    private int assignedBed;

    public boolean assignBedRoom()
    {
        for(int i = 0; i < availableBed.length; i++)
        {
            if(availableBed[i])
            {
                availableBed[i] = false;
                assignedRoom = (i / 2) + 1;
                assignedBed = (i % 2) + 1;
                return true;
            }
        }

        assignedRoom = 0;
        assignedBed = 0;
        return false;
    }

    public boolean occupyBed(int room, int bed)
    {
        if(room < 1 || room > rooms || bed < 1 || bed > 2)
        {
            return false;
        }

        int bedIndex = ((room - 1) * 2) + (bed - 1);
        if(!availableBed[bedIndex])
        {
            return false;
        }

        availableBed[bedIndex] = false;
        assignedRoom = room;
        assignedBed = bed;
        return true;
    }

    public void displayDetails(String wardName)
    {
        System.out.println("\n\n------------" + wardName + " Ward Details------------");
        for(int room = 1; room <= rooms; room++)
        {
            System.out.println("Room " + room + ":");
            for(int bed = 1; bed <= 2; bed++)
            {
                int bedIndex = ((room - 1) * 2) + (bed - 1);
                if(availableBed[bedIndex])
                {
                    System.out.println("Bed " + bed + " available");
                }
                else
                {
                    System.out.println("Bed " + bed + " occupied");
                }
            }
            System.out.println();
        }
    }

    public int getAssignedRoom()
    {
        return assignedRoom;
    }

    public int getAssignedBed() {
        return assignedBed;
    }

    public void removeBed(int bed)
    {
        int bedIndex = bed - 1;
        if(bedIndex >= 0 && bedIndex < availableBed.length)
        {
            availableBed[bedIndex]=true;
        }
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }


}
