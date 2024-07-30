package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Views.HRGui;
import Views.createGUI;
import Views.viewGui;
import Views.manGui;
import Views.bookGui;

public class hrCont {
    private HRSys model;
    private HRGui view;
    private createGUI gui;
    private viewGui viGui;
    private manGui maGui;
    private bookGui boGui;
    private String name;

    public hrCont(HRSys model, HRGui view, createGUI gui, String name){
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

        this.view.addViewHotelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    view.setVisible(true);
                    viewGui viGui = new viewGui();
                    viewCont cont = new viewCont(model, viGui, view, name);
                    cont.displayView();
            }
        });

        this.view.addManageHotelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    view.setVisible(true);
                    manGui maGui = new manGui();
                    manCont cont = new manCont(model, maGui, view, name);
                    cont.displayView();
            }
        });

        this.view.addBookRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    view.setVisible(false);
                    bookGui boGui = new bookGui();
                    bookCont cont = new bookCont(model, boGui, view, name);
                    cont.displayView();
            }
        });

        this.view.addChooseHotelListener(new ActionListener() {
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

