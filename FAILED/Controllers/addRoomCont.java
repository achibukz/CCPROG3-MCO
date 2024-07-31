package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Views.addRoom;
import Views.manGui;

public class addRoomCont {
    private HRSys model;
    private addRoom view;
    private manGui gui;
    private String name;
    private int type;

    public addRoomCont(HRSys model, addRoom view, manGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });

        this.view.addStdButListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 1;
                view.appendOutput("Standard room selected.");
            }
        });

        this.view.addDeButlListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 2;
                view.appendOutput("Deluxe room selected.");
            }
        });

        this.view.addExeButListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 3;
                view.appendOutput("Executive room selected.");
            }
        });

        this.view.addConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numRooms = view.getnumRooms();

                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure?");
                if (confirmed) {
                    model.addRooms(name, numRooms, type);
                    view.appendOutput("Room added.");
                }
                else {
                    view.appendOutput("Room not added.");
                }

               
            }
        });


    }

    public void displayView(){
        view.setVisible(true);
    }

}

