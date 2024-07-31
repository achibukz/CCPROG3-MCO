package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Models.Room;

import Models.HRSys;
import Views.manGui;
import Views.remRoom;

public class remRoomCont {
    private HRSys model;
    private remRoom view;
    private manGui gui;
    private String name;
    private ArrayList<Room> rooms;

    public remRoomCont(HRSys model, remRoom view, manGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        this.rooms = model.getAllRooms(name);
        updateOutput();

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });

        this.view.addConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure?");
                String roomNum = view.getxField();
                boolean roomFound = false;
        
                for (Room room : rooms) {
                    if (room.getRoomID().equals(roomNum)) {
                        roomFound = true;
                        break;
                    }
                }
        
                if (!roomFound) {
                    view.appendOutput("Invalid room ID.");
                    return;
                }
        
                if (confirmed) {
                    model.removeRoom(name, roomNum);
                    view.appendOutput("Removed Room.");
                } else {
                    view.appendOutput("Room not Removed.");
                }
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void updateOutput(){
        

        for (Room room : rooms){
            view.appendOutput(room.getRoomID());
        }
    }

}

