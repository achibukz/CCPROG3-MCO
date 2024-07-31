package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
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
    private Hotel name;
    private mainController cont;

    public hrCont(HRSys model, HRGui view, createGUI gui, Hotel name, mainController cont){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        this.cont = cont;


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
                    viewGui viGui = cont.getViewGui();
                    viGui.setVisible(true);
            }
        });

        this.view.addManageHotelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    view.setVisible(true);
                    manGui maGui = cont.getManGui();
                    maGui.setVisible(true);
            }
        });

        this.view.addBookRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    view.setVisible(false);
                    bookGui boGui = cont.getBookGui();
                    boGui.setVisible(true);
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

    public void setName(Hotel name){
        this.name = name;
    }



}

