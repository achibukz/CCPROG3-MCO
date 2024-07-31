package Controllers;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
import Views.HRGui;
import Views.addRoom;
import Views.manGui;
import Views.remRes;
import Views.updHotName;
import Views.updBasePrice;
import Views.remRoom;
import Views.dataPrice;
import Views.remHot;


public class manCont {
    private HRSys model;
    private manGui view;
    private HRGui gui;
    private Hotel name;
    private ArrayList<Hotel> hotels;
    private mainController cont;


    public manCont(HRSys model, manGui view, HRGui gui, Hotel name, mainController cont){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        this.hotels = model.getHotels();
        this.cont = cont;

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
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }
                view.setVisible(false);
                addRoom addRoomView = cont.getAddRoomView();
                addRoomView.setVisible(true);
            }
        });

        this.view.addRemRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }
                view.setVisible(false);
                remRoom remRoomView = cont.getRemRoomView();
                remRoomView.setVisible(true);
            }
        });

        this.view.addUpdHotelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }
                view.setVisible(false);
                updHotName updHotNameView = cont.getUpdHotNameView();
                updHotNameView.setVisible(true);
            }
        });

        this.view.addUpdBasePriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }
                else if (model.getHotel(name).estEarn() != 0){
                    view.appendOutput("Cannot update base price. Hotel has already earned money.");
                    return;
                }
                else{
                    view.setVisible(false);
                    updBasePrice updBasePriceView = cont.getUpdBasePriceView();
                    updBasePriceView.setVisible(true);
                }
            }
        });

        this.view.addRemResListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }
                else{
                    view.setVisible(false);
                    remRes remResView = cont.getRemResView();
                    remResView.setVisible(true);
                }
                
            }
        });

        this.view.addRemHotListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }
                else if(model.getHotel(name).estEarn() != 0){
                    view.appendOutput("Cannot remove hotel. Hotel has already earned money.");
                    return;
                }
                
                view.setVisible(false);
                remHot remHotView = cont.getRemHotView();
                remHotView.setVisible(true);
            }
        });

        this.view.addDataPriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getHotelIndex(name) < 0){
                    view.appendOutput("Hotel does not exist.");
                    return;
                }else if (model.getHotel(name).estEarn() != 0){
                    view.appendOutput("Cannot update data price. Hotel has already earned money.");
                    return;
                }
                else{
                    view.setVisible(false);
                    dataPrice dataPriceView = cont.getDataPriceView();
                    dataPriceView.setVisible(true);
                }
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

