package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
import Views.highLev;
import Views.viewGui;

public class highLevCont {
    private HRSys model;
    private highLev view;
    private viewGui gui;
    private Hotel hotel;

    public highLevCont(HRSys model, highLev view, viewGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.hotel = model.getHotel(name);
        updateView();

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });
    }

    public void updateView(){
        view.setHotName(hotel.getName());
        view.setHotRooms(hotel.getNumRooms());
        view.setHotEarnings(hotel.estEarn());
    }

    public void displayView(){
        view.setVisible(true);
    }

    public String getHotelName(){
        return hotel.getName();
    }

    public int getHotelRooms(){
        return hotel.getNumRooms();
    }

    public double getEarnings(){
        return hotel.estEarn();
    }

}

