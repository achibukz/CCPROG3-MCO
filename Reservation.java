import java.util.ArrayList;

/**
 * The Reservation class represents a reservation made by a guest for a room.
 */
public class Reservation {
    
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private ArrayList<Double> costPerNight = new ArrayList<Double>();
    private double totalCost;
    private Room room;

    /**
     * Constructs a Reservation object with the specified guest name, check-in date, check-out date, cost per night, and room.
     * 
     * @param guestName the name of the guest making the reservation
     * @param checkInDate the check-in date of the reservation
     * @param checkOutDate the check-out date of the reservation
     * @param costPerNight the cost per night of the room
     * @param room the room being reserved
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room){
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        room.bookRoom(checkInDate, checkOutDate);
        setTotalCost();
        setCostperNight();
    }

    /**
     * Returns the room associated with this reservation.
     * 
     * @return room - the room associated with this reservation
     */
    public Room getRoom(){
        return room;
    }

    /**
     * Returns the name of the guest making the reservation.
     * 
     * @return guestName - the name of the guest making the reservation
     */
    public String getGuestName(){
        return guestName;
    }

    /**
     * Returns the check-in date of the reservation.
     * 
     * @return checkInDate - the check-in date of the reservation
     */
    public int getCheckInDate(){
        return checkInDate;
    }

    /**
     * Returns the check-out date of the reservation.
     * 
     * @return checkOutDate - the check-out date of the reservation
     */
    public int getCheckOutDate(){
        return checkOutDate;
    }

    /**
     * Returns the cost per night of the room.
     * 
     * @return costPerNight - the cost per night of the room
     */
    public ArrayList<Double> getCostPerNight(){
        return costPerNight;
    }

    /**
     * Returns the total cost of the reservation.
     * 
     * @return totalCost - the total cost of the reservation
     */
    public void setTotalCost(){

        ArrayList<Double> discounts = new ArrayList<Double>();

        for (int i = checkInDate; i < checkOutDate; i++){
            discounts.add(room.getDisc(i));
        }

        for (int i = 0; i < discounts.size(); i++){
            totalCost += room.getPrice() * discounts.get(i);
        }

    }

    public void setCostperNight(){
        for (int i = checkInDate; i < checkOutDate; i++){
            costPerNight.add(room.getPrice() * room.getDisc(i));
        }
    }

    public double getTotalCost(){
        return totalCost;
    }

    public void manipulatePrice(int check){
        if (check == 1){
            this.totalCost = totalCost * 0.9;
        }
        else if(check == 2){
            this.totalCost = totalCost - costPerNight.get(0);
        }
        else if(check == 3){
            this.totalCost = totalCost * 0.92;
        }
    }


}
