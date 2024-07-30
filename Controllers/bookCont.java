package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import Models.HRSys;
import Models.Room;
import Views.bookGui;
import Views.HRGui;

public class bookCont {
    private HRSys model;
    private bookGui view;
    private HRGui gui;
    private String name;

    public bookCont(HRSys model, bookGui view, HRGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        updateOutput();

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
                updateOutput();
            }
        });

        this.view.addConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guest = view.getName();
                int checkIn = view.getCheckIn();
                int checkOut = view.getCheckOut();
                String discountCode = view.getDiscountCode();
                String roomID = view.getRoomID();

                if (checkIn >= checkOut){
                    view.appendOutput("Invalid check-in and check-out dates.");
                    return;
                }
                else if(checkIn < 1 || checkIn > 31 || checkOut == 1 || checkOut > 31){
                    view.appendOutput("Invalid check-in and check-out dates.");
                    return;
                }

                if (roomID == null){
                    view.appendOutput("Invalid room ID.");
                    return;
                }
                

                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure you want to book this room?");

                if (confirmed){
                    model.booking(name, guest, roomID, checkIn, checkOut, discountCode);
                    view.appendOutput("Room booked.");
                }
                else{
                    view.appendOutput("Room not booked.");
                }
            }
        });

    }

    public void displayView(){
        view.setVisible(true);
    }

    public void updateOutput(){
        view.appendOutput("Hotel: " + name);

        ArrayList<Room> stdrooms = model.getAvailableStdRoom(name);
        ArrayList<Room> dexroom = model.getAvailableDelRoom(name);
        ArrayList<Room> exeRooms = model.getAvailableExecRoom(name);

        view.appendOutput("Standard Rooms: ");
        for (Room room : stdrooms){
            view.appendOutput(room.getRoomID());
        }

        view.appendOutput("Deluxe Rooms: ");
        for (Room room : dexroom){
            view.appendOutput(room.getRoomID());
        }

        view.appendOutput("Executive Rooms: ");
        for (Room room : exeRooms){
            view.appendOutput(room.getRoomID());
        }
        
    }

}

