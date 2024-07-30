package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
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

