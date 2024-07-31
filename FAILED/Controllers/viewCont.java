package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
import Views.HRGui;
import Views.viewGui;
import Views.lowLev;
import Views.highLev;


public class viewCont {
    private HRSys model;
    private viewGui view;
    private HRGui gui;
    private Hotel name;
    private mainController cont;

    public viewCont(HRSys model, viewGui view, HRGui gui, Hotel name , mainController cont){
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

        this.view.addLowLevListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                lowLev lowLevView = cont.getLowLevView();
                lowLevView.setVisible(true);
            }
        });

        this.view.addHighLevListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                highLev highLevView = cont.getHighLevView();
                highLevView.setVisible(true);
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void setName(Hotel name) {
        this.name = name;
    }

}

