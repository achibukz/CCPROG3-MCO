package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
import Views.HRGui;
import Views.createGUI;

public class creCont {
    private HRSys model;
    private createGUI view;
    private String hotelName;
    private mainController cont;
    private Hotel hotel;

    public creCont(HRSys model, createGUI view, mainController cont){
        this.model = model;
        this.view = view;
        this.cont = cont;

        this.view.addCHL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getHotelName();
                int std = view.getStdRooms();
                int del = view.getDelRooms();
                int exec = view.getExecRooms();

                if (name.equals("")){
                    view.appendOutput("Please enter a hotel name.");
                }
                else if(model.checkIfNameExists(name)){
                    displayCheck(name);
                }
                else if(std + del + exec < 1){
                    view.appendOutput("Total rooms must be at least 1. Please adjust sliders.");
                }
                else if (std + del + exec > 50){
                    view.appendOutput("Total rooms cannot exceed 50. Please adjust sliders.");
                }
                else{
                    model.createHotel(name, std, del, exec);
                    setHotel(model.getHotel());
                    cont.setName(hotel);
                    
                    view.appendOutput("Hotel created: " + name + " with " + std + " standard rooms, " + del + " deluxe rooms, and " + exec + " executive rooms.");
                }
            }
        });

        this.view.nextWindow(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (model.getHotelSize() == 0){
                    view.appendOutput("Please create a hotel first.");
                }
                else{
                    view.setVisible(false);
                    HRGui hrgui = new HRGui(hotel.getName());
                    hrCont hrcont = new hrCont(model, hrgui, view, hotel, cont);
                    cont.setHrCont(hrcont);
                    hrgui.setVisible(true);
                }
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void displayCheck(String name){
        if (model.checkIfNameExists(name)){
            view.appendOutput("Hotel " + name + " exists.");
        }
        else{
            view.appendOutput("Hotel " + name + " does not exist.");
        }
    }

    public String getHotelName(){
        return hotelName;
    }

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }

}

