package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Views.HRGui;
import Views.addRoom;
import Views.manGui;
import Views.remRoom;
import Views.updHotName;
import Views.updBasePrice;
import Views.remRes;
import Views.remHot;
import Views.dataPrice;


public class manCont {
    private HRSys model;
    private manGui view;
    private HRGui gui;
    private String name;

    public manCont(HRSys model, manGui view, HRGui gui, String name){
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

        this.view.addAddRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                addRoom addRoomView = new addRoom();
                addRoomCont addRoomCont = new addRoomCont(model, addRoomView, view, name);
                addRoomCont.displayView();
            }
        });

        this.view.addRemRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                remRoom remRoomView = new remRoom();
                remRoomCont remRoomCont = new remRoomCont(model, remRoomView, view, name);
                remRoomCont.displayView();
            }
        });

        this.view.addUpdHotelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                updHotName updHotNameView = new updHotName();
                updHotCont updHotNameCont = new updHotCont(model, updHotNameView, view, name);
                updHotNameCont.displayView();
            }
        });

        this.view.addUpdBasePriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                updBasePrice updBasePriceView = new updBasePrice();
                updBasePriceCont updBasePriceCont = new updBasePriceCont(model, updBasePriceView, view, name);
                updBasePriceCont.displayView();
            }
        });

        this.view.addRemResListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                remRes remResView = new remRes();
                remResCont remResCont = new remResCont(model, remResView, view, name);
                remResCont.displayView();
            }
        });

        this.view.addRemHotListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                remHot remHotView = new remHot();
                remHotCont remHotCont = new remHotCont(model, remHotView, view, name);
                remHotCont.displayView();
            }
        });

        this.view.addDataPriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                dataPrice dataPriceView = new dataPrice();
                dataPriceCont dataPriceCont = new dataPriceCont(model, dataPriceView, view, name);
                dataPriceCont.displayView();
            }
        });




    }

    public void displayView(){
        view.setVisible(true);
    }

}

