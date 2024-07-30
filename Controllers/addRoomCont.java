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
    }

    public void displayView(){
        view.setVisible(true);
    }

}

