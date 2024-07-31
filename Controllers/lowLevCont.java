package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import Models.Room;
import Models.Reservation;
import java.util.ArrayList;

import Models.HRSys;
import Views.lowLev;
import Views.viewGui;


public class lowLevCont {
    private HRSys model;
    private lowLev view;
    private viewGui gui;
    private String name;

    public lowLevCont(HRSys model, lowLev view, viewGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        updateOutput1();
        viewOutput2();
        viewOutput3();

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void updateOutput1(){
        view.appendOutput1("Hotel Name: " + name);
        view.appendOutput1("Available Rooms");

        ArrayList<Room> avail = new ArrayList<Room>();
        ArrayList<Room> book = new ArrayList<Room>();

        for (Room room : model.getAvailableStdRoom(name)) {
            avail.add(room);
        }
        for (Room room : model.getAvailableDelRoom(name)) {
            avail.add(room);
        }
        
        for (Room room : model.getAvailableExecRoom(name)) {
            avail.add(room);
        }

        for (Room room : avail) {
            view.appendOutput1(room.getRoomID());
        }
        view.appendOutput1("----------------------------------");

        view.appendOutput1("Booked Rooms");

        for (Room room : model.getBookedStdRoom(name)) {
            book.add(room);
        }

        for (Room room : model.getBookedDelRoom(name)) {
            book.add(room);
        }

        for (Room room : model.getBookedExecRoom(name)) {
            book.add(room);
        }

        for (Room room : book) {
            view.appendOutput1(room.getRoomID());
        }

    }

    public void viewOutput2(){
        view.appendOutput2("Hotel Name: " + name);

        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms = model.getAllRooms(name);

        for (Room room : rooms) {
            view.appendOutput2(room.getRoomID());
            view.appendOutput2("Price: " + room.getPrice());
            view.appendOutput2("Availability: " + room.getAllAvail());
            view.appendOutput2("----------------------------------");

        }


    }

    public void viewOutput3(){
        view.appendOutput3("Hotel Name: " + name);

        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        reservations = model.getAllReservations(name);

        for (Reservation res : reservations) {
            view.appendOutput3(res.getGuestName());
            view.appendOutput3(res.getRoom().getRoomID());
            view.appendOutput3(res.getCheckInDate() + " - " + res.getCheckOutDate());
            view.appendOutput3("Total Cost: " + res.getTotalCost());
            view.appendOutput3("----------------------------------");
        }
        
    }

}

