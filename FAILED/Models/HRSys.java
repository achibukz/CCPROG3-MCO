package Models;

import java.util.Scanner;

import Controllers.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The HRSys class represents a hotel reservation system that manages hotels, rooms, and reservations.
 */
public class HRSys {

    private ArrayList<Hotel> hotels;
    private List<Observer> observers = new ArrayList<>();



    /**
     * Constructs an HRSys object with an empty list of hotels.
     */
    public HRSys(){
        hotels = new ArrayList<Hotel>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Checks if a hotel with the specified name already exists.
     *
     * @param name the name of the hotel
     * @return true if a hotel with the specified name exists, false otherwise
     */
    public boolean checkIfNameExists(String name){
        name = name.toLowerCase();
        for(Hotel hotel : hotels){
            if(hotel.getName().toLowerCase().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a line of dashes to separate sections in the menu.
     */
    public void blank(){
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * Lets you press any key to continue.
     */
    public void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to read input.");
            e.printStackTrace();
        }
}

    /**
     * Displays a confirmation message and returns true if the user confirms, false otherwise.
     *
     * @return true if the user confirms, false otherwise
     */
    public boolean confirmation() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you sure? (Y/N): ");
        String confirmation = scan.nextLine();

        return confirmation.equalsIgnoreCase("Y");
    }

    /**
     * main function to create a new instance of a Hotel.
     */
    public void createHotel(String name, int stdCnt, int delCnt, int execCnt){
        Hotel hotel = new Hotel(name, stdCnt, delCnt, execCnt);
        hotels.add(hotel);

    }

    /**
     * Displays all hotels and prompts the user to select a hotel.
     * @return hotelNumber the number of the hotel selected by the user
     */
    public void displayAllHotels(String name){

        int hotelNumber = getHotelIndex(name);

        int count = 1;
        blank();
        System.out.println("Hotels:");
        blank();
        for(Hotel hotel : hotels){
            System.out.println(count + ": " + hotel.getName());
            count++;
        }
        blank();
    
    }

    /**
     * Displays all rooms in a hotel and prompts the user to select a room.
     * @param hotelNumber the number of the hotel
     * @param check the type of room to display (1: all rooms, 2: available rooms, 3: booked rooms)
     * @return roomNumber the number of the room selected by the user
     */
    public int displayAllRooms(int hotelNumber, int check){
        Scanner scan = new Scanner(System.in);

        String hotelName = hotels.get(hotelNumber - 1).getName();
        int count = 1;

        if (check == 1){
            blank();
            System.out.println("Standard Rooms in " + hotelName + ":");
            blank();
            for(Room room : hotels.get(hotelNumber - 1).getRooms(1)){
                System.out.println(count + ": " + room.getRoomID());
                count++;
            }
            blank();

            blank();
            System.out.println("Deluxe Rooms in " + hotelName + ":");
            blank();
            for(Room room : hotels.get(hotelNumber - 1).getRooms(2)){
                System.out.println(count + ": " + room.getRoomID());
                count++;
            }
            blank();

            blank();
            System.out.println("Executive Rooms in " + hotelName + ":");
            blank();
            for(Room room : hotels.get(hotelNumber - 1).getRooms(3)){
                System.out.println(count + ": " + room.getRoomID());
                count++;
            }
            blank();
        }
        if (check == 2) {
            blank();
            System.out.println("Available Standard Rooms in " + hotelName + ":");
            blank();
            for (Room room : hotels.get(hotelNumber - 1).getRooms(1)) {
                if (!room.isBook()) {
                    System.out.println(count + ": " + room.getRoomID());
                    count++;
                }
            }
            blank();

            blank();
            System.out.println("Available Deluxe Rooms in " + hotelName + ":");
            blank();
            for (Room room : hotels.get(hotelNumber - 1).getRooms(2)) {
                if (!room.isBook()) {
                    System.out.println(count + ": " + room.getRoomID());
                    count++;
                }
            }

            blank();
            blank();
            System.out.println("Available Executive Rooms in " + hotelName + ":");
            blank();
            for (Room room : hotels.get(hotelNumber - 1).getRooms(3)) {
                if (!room.isBook()) {
                    System.out.println(count + ": " + room.getRoomID());
                    count++;
                }
            }
            blank();

        } else if (check == 3) {
            blank();
            System.out.println("Booked Standard Rooms in " + hotelName + ":");
            blank();
            for (Room room : hotels.get(hotelNumber - 1).getRooms(1)) {
                if (room.isBook()) {
                    System.out.println(count + ": " + room.getRoomID());
                    count++;
                }
            }
            blank();

            blank();
            System.out.println("Booked Deluxe Rooms in " + hotelName + ":");
            blank();
            for (Room room : hotels.get(hotelNumber - 1).getRooms(2)) {
                if (room.isBook()) {
                    System.out.println(count + ": " + room.getRoomID());
                    count++;
                }
            }
            blank();

            blank();
            System.out.println("Booked Executive Rooms in " + hotelName + ":");
            blank();
            for (Room room : hotels.get(hotelNumber - 1).getRooms(3)) {
                if (room.isBook()) {
                    System.out.println(count + ": " + room.getRoomID());
                    count++;
                }
            }
            blank();
        }

        

        System.out.println("Enter the RoomID of the room: ");
        int roomNumber = scan.nextInt();
        scan.nextLine();

        while (roomNumber < 1 || roomNumber > count - 1) {
            System.out.println("Invalid room number. Please enter a valid number: ");
            roomNumber = scan.nextInt();
            scan.nextLine();
        }

        return roomNumber;
    }

    /**
     * Displays the availability of a room for the month.
     * @param room the room to display the availability for
     */
    public void displayRoomMonth(Room room){
        blank();
        System.out.println("Room ID: " + room.getRoomID());
        blank();
        System.out.println("Room Availability for the Month:");
        blank();
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%-3d", i);
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        blank();
    }

    /**
     * Select the reservation to view.
     * @param hotelNumber the number of the hotel
     * @return reservationName the name of the reservation selected by the user
     */
    public String selectReservation(int hotelNumber){
        Scanner scan = new Scanner(System.in);

        String hotelName = hotels.get(hotelNumber - 1).getName();
        int count = 1;

        blank();
        System.out.println("Reservations in " + hotelName + ":");
        blank();
        for(Reservation reservation : hotels.get(hotelNumber - 1).getReservations()){
            System.out.println(count + ": " + reservation.getGuestName());
            count++;
        }
        blank();

        System.out.println("Enter the name of the reservation: ");
        String reservationName = scan.nextLine();

        while(hotels.get(hotelNumber - 1).crossReservation(reservationName) == null){
            System.out.println("Invalid reservation name.");
            System.out.println("Enter the name of the reservation: ");
            reservationName = scan.nextLine();
        }

        return reservationName;
    }

    /**
     * Display all reservations in a hotel.
     * @param hotelNumber the number of the hotel
     * @return reservationNumber the number of the reservation selected by the user
     */
    public int displayAllReservations(int hotelNumber){
        Scanner scan = new Scanner(System.in);

        String hotelName = hotels.get(hotelNumber - 1).getName();
        int count = 1;

        if (hotels.get(hotelNumber - 1).getReservations().size() == 0) {
            blank();
            System.out.println("No reservations in " + hotelName + ".");
            blank();
            pressAnyKeyToContinue();
            return 0;
        }


        blank();
        System.out.println("Reservations in " + hotelName + ":");
        blank();
        for(Reservation reservation : hotels.get(hotelNumber - 1).getReservations()){
            System.out.println(count + ": " + reservation.getGuestName());
            count++;
        }
        blank();

        System.out.println("Enter the number of the reservation: ");
        int reservationNumber = scan.nextInt();
        scan.nextLine();

        while (reservationNumber < 1 || reservationNumber > count - 1) {
            System.out.println("Invalid number of reservation. Please enter a valid number: ");
            reservationNumber = scan.nextInt();
            scan.nextLine();
        }

        return reservationNumber;
    }


    /**
     * Main function to view all information about the hotel.
     */
    // public void viewHotel(){
    //     if(hotels.size() == 0){
    //         blank();
    //         System.out.println("No Hotels to View. Please Create a Hotel First.");
    //     }
    //     else{
    //         Scanner scan = new Scanner(System.in);

    //         String hotelName = hotels.get(hotelNumber - 1).getName();
        

    //         blank();
    //         System.out.println("Hotel Name: " + hotelName);
    //         blank();
    //         System.out.println("Accessible Information:");
    //         System.out.println("    1: High-level Information");
    //         System.out.println("    2: Low-level Information");
    //         blank();
    //         System.out.println("Enter the number of your choice: ");
    //         int choice = scan.nextInt();

    //         blank();
    //         if(choice == 1){
    //             System.out.println("High-level Information:");
            
    //             System.out.println("    Hotel Name: " + hotelName);
    //             System.out.println("    Number of Rooms: " + hotels.get(hotelNumber - 1).getNumRooms());
    //             System.out.println("    Estimated Earnings of the Month: " + hotels.get(hotelNumber - 1).estEarn()); 
    //         }
    //         else if(choice == 2){
    //             System.out.println("Low-level Information Menu:");

    //             System.out.println("    1: Check Availability of Rooms");
    //             System.out.println("    2: View Rooms Informations");
    //             System.out.println("    3: View Reservations");

    //             blank();

    //             System.out.println("Enter the number of your choice: ");
    //             int choice2 = scan.nextInt();
    //             blank();
            
    //             if(choice2 == 1){
    //                 calendar();
    //                 System.out.println("Enter the date: ");
    //                 int date = scan.nextInt();
                        
    //                 System.out.println("    Available Rooms: " + hotels.get(hotelNumber - 1).countAvail(date));
    //                 System.out.println("    Booked Rooms: " + hotels.get(hotelNumber - 1).countBooked(date)); 
    //             }
    //             else if (choice2 == 2){
    //                 int room = displayAllRooms(hotelNumber, 1);

    //                 System.out.println("    Room ID: " + hotels.get(hotelNumber - 1).getRooms(4).get(room - 1).getRoomID());
    //                 System.out.println("    Room Price: " + hotels.get(hotelNumber - 1).getRooms(4).get(room - 1).getPrice()); 
    //                 System.out.println("    Room Status for the Days: "); 
    //                 System.out.println(hotels.get(hotelNumber - 1).getRooms(4).get(room - 1).getAllAvail());
    //             }
    //             else if (choice2 == 3){
    //                 //Information about Reservation
    //                 // FUNC CHOOSE RESERVATION
    //                 int reservation = displayAllReservations(hotelNumber);

    //                 if (reservation != 0) {
    //                     System.out.println("    Guest Name: " + hotels.get(hotelNumber - 1).getReservations().get(reservation - 1).getGuestName()); 
    //                     System.out.println("    Room Name: " + hotels.get(hotelNumber - 1).getReservations().get(reservation - 1).getRoom().getRoomID());
    //                     System.out.println("    Check-in Date: " + hotels.get(hotelNumber - 1).getReservations().get(reservation - 1).getCheckInDate()); 
    //                     System.out.println("    Check-out Date:  " + hotels.get(hotelNumber - 1).getReservations().get(reservation - 1).getCheckOutDate()); 
    //                     System.out.println("    Price per Night: "); 
    //                     ArrayList<Double> costPerNight = hotels.get(hotelNumber - 1).getReservations().get(reservation - 1).getCostPerNight();
    //                     for (int i = 0; i < costPerNight.size(); i++) {
    //                         System.out.println("        Day " + (i + 1) + ": " + costPerNight.get(i));
    //                     }
    //                     System.out.println("    Total Price: " + hotels.get(hotelNumber - 1).getReservations().get(reservation - 1).getTotalCost()); 
    //                 }

                    
    //             }
    //             else{
    //                 System.out.println("Invalid choice");
    //                 viewHotel();
    //             }
    //         }   
    //         else{
    //             System.out.println("Invalid choice");
    //             viewHotel();
    //         }
    //     }

    //     blank();
    //     pressAnyKeyToContinue();
    // }

    /**
     * Update the name of the hotel.
     * @param hotelNumber the number of the hotel
     */
    public void updHotelName(String Hotelname, String newName){
        int index = getHotelIndex(Hotelname);
        hotels.get(index).updName(newName);

        notifyObservers();
    }

    /**
     * Add rooms to the hotel.
     * @param hotelNumber the number of the hotel
     */
    public void addRooms(String name, int numRooms, int type){
        int hotelNumber = getHotelIndex(name);

        // System.out.println("Enter the number of rooms to add: ");
        // int total = hotels.get(hotelNumber - 1).getNumRooms() + numRooms;

        // while (total < 1 || total > 50) {
        //     System.out.println("Invalid number of rooms. Please enter a number between 1 and : " + (50 - hotels.get(hotelNumber - 1).getNumRooms()));
        //     numRooms = scan.nextInt();
        //     total = hotels.get(hotelNumber - 1).getNumRooms() + numRooms;
        // }

        int choice;

        blank();
        System.out.println("Select the type of room to add:");
        System.out.println("1: Standard Room");
        System.out.println("2: Deluxe Room");
        System.out.println("3: Executive Room");
        blank();

        System.out.println("Enter the number of your choice: ");
        choice = type;

        // while (choice < 1 || choice > 3) {
        //     System.out.println("Invalid choice. Please enter a number between 1 and 3: ");
        //     choice = scan.nextInt();
        // }

            System.out.println("Rooms added.");
            
            for (int i = 0; i < numRooms; i++) {
                hotels.get(hotelNumber).addRoom(choice);
            }
        
    }

    /**
     * Remove rooms from the hotel.
     * @param hotelNumber the number of the hotel
     */
    public void removeRoom(String name, String roomID){

        int hotelNumber = getHotelIndex(name);



        String roomName = roomID;


        hotels.get(hotelNumber).removeRoom(roomName);
 
    }

    /**
     * Update the base price of the hotel.
     * @param hotelNumber the number of the hotel
     */
    public void updBasePrice(String name, double basePrice){

        int hotelNumber = getHotelIndex(name);

        hotels.get(hotelNumber).updBasePrice(basePrice);
    }

    /**
     * Remove a reservation from the hotel.
     * @param hotelNumber the number of the hotel
     */
    public void removeReservation(String Hotelname, String guestName){
        int hotelNumber = getHotelIndex(Hotelname);

        hotels.get(hotelNumber).removeReservation(guestName);
        
    }

    /**
     * Remove a hotel from the system.
     * @param hotelNumber the number of the hotel
     */
    public void removeHotel(String name){

        int hotelNumber = getHotelIndex(name);
        hotels.remove(hotelNumber);

    }

    public void updateDisc(String name, int date, double disc){
        int hotelNumber = getHotelIndex(name);

        hotels.get(hotelNumber).updDisc(date, disc);

    }

    /**
     * Display the calendar for the month.
     */
    public void calendar(){
        blank();
        System.out.println("Calendar:");
        blank();
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%-3d", i);
            if (i % 7 == 0) {
            System.out.println();
            }
        }
        System.out.println();
        blank();
    }

    /**
     * Main function to book a room.
     */
    public void booking(String Hotelname, String guest, String roomID, int checkIn, int checkOut, String discountCode){

            int hotelNumber = getHotelIndex(Hotelname);
            String guestName = guest;

            int checkInDate = checkIn;

            boolean validCheckInDate = false;

            // while (!validCheckInDate) {
            //     if (checkInDate < 1 || checkInDate >= 31) {
            //         System.out.println("Invalid check-in date. Please enter 1 - 30: ");
            //         checkInDate = scan.nextInt();
            //     } 
            //     else {
            //         if (!hotels.get(hotelNumber - 1).getAllState(checkInDate)) {
            //             System.out.println("No available rooms on the check-in date. Please enter again: ");
            //             checkInDate = scan.nextInt();
            //         } 
            //         else {
            //             validCheckInDate = true;
            //         }
            //     }
            // }

            int checkOutDate = checkOut;

            boolean validCheckOutDate = false;

            // while (!validCheckOutDate) {
            //     if (checkOutDate == 1) {
            //         System.out.println("You cannot check out at 1. Please enter again: ");
            //         checkOutDate = scan.nextInt();
            //     } else if (checkOutDate < checkInDate) {
            //         System.out.println("Invalid check-out date. Please enter date after Check In: ");
            //         checkOutDate = scan.nextInt();
            //     } else {
            //         validCheckOutDate = true;
            //     }
            // }


            
            String roomName = roomID;



            Room room = hotels.get(hotelNumber).crossRoom(roomName);

            String code;

            code = discountCode;

            int check = 0;

            if (code.equals("I_WORK_HERE")) {
                check = 1;
                System.out.println("You get a 10% discount.");
            }
            else if (code.equals("STAY4_GET1")) {
                if((checkOutDate - checkInDate) >= 5){
                    check = 2;
                    System.out.println("You get one day free.");
                }
                else{
                    System.out.println("You need to stay for at least 5 days to get a free day.");
                }
            }
            else if (code.equals("PAYDAY")) {
                if ((15 >= checkInDate && 15 <= checkOutDate && !(checkOutDate == 15)) || (30 >= checkInDate && 30 <= checkOutDate && !(checkOutDate == 30))) {
                    check = 3;
                    System.out.println("You get a 7% Discount.");
                }
                else{
                    System.out.println("You need to stay on the 15th or 30th to get a discount.");
                }
            }
            else{
                System.out.println("Invalid/No Discount Code.");
            }

                if (check == 0) {
                    hotels.get(hotelNumber).addReservation(guestName, checkInDate, checkOutDate, room, 0);
                }
                else if (check == 1){
                    hotels.get(hotelNumber).addReservation(guestName, checkInDate, checkOutDate, room, 1);
                }
                else if (check == 2){
                    hotels.get(hotelNumber).addReservation(guestName, checkInDate, checkOutDate, room, 2);
                }
                else if (check == 3){
                    hotels.get(hotelNumber).addReservation(guestName, checkInDate, checkOutDate, room, 3);
                }

                room.bookRoom(checkInDate, checkOutDate);
                System.out.println("Room booked."); 


    }

    public int getHotelSize(){
        return hotels.size();
    }

    public int getHotelIndex(String name) {
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Hotel getHotel(String name) {
        int index = getHotelIndex(name);
        
        return hotels.get(index);
        
    }

    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    public ArrayList<Room> getAvailableStdRoom(String name){
        int hotelNumber = getHotelIndex(name);
        ArrayList<Room> availRooms = new ArrayList<Room>();

        for (Room room : hotels.get(hotelNumber).getRooms(1)) {
            if (!room.isBook()) {
                availRooms.add(room);
            }
        }

        return availRooms;
    }

    public ArrayList<Room> getAvailableDelRoom(String name){
        int hotelNumber = getHotelIndex(name);
        ArrayList<Room> availRooms = new ArrayList<Room>();

        for (Room room : hotels.get(hotelNumber).getRooms(2)) {
            if (!room.isBook()) {
                availRooms.add(room);
            }
        }

        return availRooms;
    }

    public ArrayList<Room> getAvailableExecRoom(String name){
        int hotelNumber = getHotelIndex(name);
        ArrayList<Room> availRooms = new ArrayList<Room>();

        for (Room room : hotels.get(hotelNumber).getRooms(3)) {
            if (!room.isBook()) {
                availRooms.add(room);
            }
        }

        return availRooms;
    }

    public ArrayList<Room> getAllRooms(String name){
        int hotelNumber = getHotelIndex(name);
        ArrayList<Room> allRooms = new ArrayList<Room>();

        for (Room room : hotels.get(hotelNumber).getRooms(1)) {
            allRooms.add(room);
        }

        for (Room room : hotels.get(hotelNumber).getRooms(2)) {
            allRooms.add(room);
        }

        for (Room room : hotels.get(hotelNumber).getRooms(3)) {
            allRooms.add(room);
        }

        return allRooms;
    }

    public ArrayList<Reservation> getAllReservations(String name){
        int hotelNumber = getHotelIndex(name);
        return hotels.get(hotelNumber).getReservations();
    }


}
