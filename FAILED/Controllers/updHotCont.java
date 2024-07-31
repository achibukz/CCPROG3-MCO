package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Models.Hotel;
import Views.manGui;
import Views.updHotName;

public class updHotCont {
    private HRSys model;
    private updHotName view;
    private manGui gui;
    private Hotel name;
    private mainController cont;

    public updHotCont(HRSys model, updHotName view, manGui gui, Hotel name, mainController cont){
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

        this.view.addUpdateNameListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = view.getUpdateName();
                if (newName.equals("")){
                    view.appendOutput("Please enter a new hotel name.");
                }
                else if(model.checkIfNameExists(newName)){
                    view.appendOutput("Hotel name already exists. Please enter a different name.");
                }
                else{
                    boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure you want to update the hotel name?");
                    
                    if(confirmed){
                        model.updHotelName(name, newName);
                        view.appendOutput("Hotel name updated to: " + newName);
                    }
                    else{
                        view.appendOutput("Hotel name not updated.");
                    }

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

