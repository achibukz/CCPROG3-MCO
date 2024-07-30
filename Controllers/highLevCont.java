package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
import Views.highLev;
import Views.viewGui;

public class highLevCont implements Observer {
    private HRSys model;
    private highLev view;
    private viewGui gui;
    private String name;

    public highLevCont(HRSys model, highLev view, viewGui gui, String name) {
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;

        model.addObserver(this); // Register as an observer
        updateView();

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });
    }

    @Override
    public void update() {
        updateView();
    }

    public void updateView() {
        Hotel hotel = model.getHotel(name);
        if (hotel != null) {
            String hotelName = hotel.getName();
            int hotelRooms = hotel.getNumRooms();
            double hotelEarnings = hotel.estEarn();

            view.setHotName(hotelName);
            view.setHotRooms(hotelRooms);
            view.setHotEarnings(hotelEarnings);
        }
    }

    public void displayView() {
        view.setVisible(true);
    }

    public String getHotelName() {
        return model.getHotel(name).getName();
    }

    public int getHotelRooms() {
        return model.getHotel(name).getNumRooms();
    }

    public double getEarnings() {
        return model.getHotel(name).estEarn();
    }
}
