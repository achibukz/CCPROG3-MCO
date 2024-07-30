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

        this.view.addStdListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 1;
            }
        });

        this.view.addDelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 2;
            }
        });

        this.view.addExeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = 3;
            }
        });

        this.view.addStdButListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRoom(name, type, Integer.parseInt(view.getStdRooms()));
            }
        });


    }

    public void displayView(){
        view.setVisible(true);
    }

}

