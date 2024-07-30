package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Views.HRGui;
import Views.viewGui;
import Views.lowLev;
import Views.highLev;


public class viewCont {
    private HRSys model;
    private viewGui view;
    private HRGui gui;
    private String name;

    public viewCont(HRSys model, viewGui view, HRGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;

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
                lowLev lowLevView = new lowLev();
                lowLevCont lowLevCont = new lowLevCont(model, lowLevView, view, name);
                lowLevCont.displayView();
            }
        });

        this.view.addHighLevListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                highLev highLevView = new highLev();
                highLevCont highLevCont = new highLevCont(model, highLevView, view, name);
                highLevCont.displayView();
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

}

