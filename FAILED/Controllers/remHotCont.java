package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Models.HRSys;
import Models.Hotel;
import Views.manGui;
import Views.remHot;

public class remHotCont {
    private HRSys model;
    private remHot view;
    private manGui gui;
    private String name;
    private ArrayList<Hotel> hotels;

    public remHotCont(HRSys model, remHot view, manGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        updateOutput();

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });

        this.view.addConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure you want to remove this hotel?");
                
                if(confirmed){
                    model.removeHotel(name);
                    view.appendOutput("Hotel removed.");
                }
                else{
                    view.appendOutput("Hotel not removed.");
                }

            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void updateOutput(){
        hotels = model.getHotels();
        int i = 1;
        for (Hotel hotel : hotels){
            view.appendOutput(i + " : "+ hotel.getName());
            i++;
        }
    }

}

