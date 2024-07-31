package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Reservation;
import java.util.ArrayList;

import Models.HRSys;
import Views.manGui;
import Views.remRes;

public class remResCont {
    private HRSys model;
    private remRes view;
    private manGui gui;
    private String name;
    private ArrayList<Reservation> reservations;

    public remResCont(HRSys model, remRes view, manGui gui, String name){
        this.model = model;
        this.view = view;
        this.gui = gui;
        this.name = name;
        this.reservations = model.getAllReservations(name);
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
                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure?");
                String guestName = view.getxField();
                boolean resFound = false;
        
                for (Reservation res : reservations) {
                    if (res.getGuestName().equals(guestName)) {
                        resFound = true;
                        break;
                    }
                }
        
                if (!resFound) {
                    view.appendOutput("Invalid reservation name.");
                    return;
                }
        
                if (confirmed) {
                    model.removeReservation(name, guestName);
                    view.appendOutput("Removed Reservation.");
                } else {
                    view.appendOutput("Reservation not Removed.");
                }
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void updateOutput(){
        for (Reservation res : reservations) {
            view.appendOutput(res.getGuestName());
        }
    }

}

