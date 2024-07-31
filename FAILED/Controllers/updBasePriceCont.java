package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Views.manGui;
import Views.updBasePrice;

public class updBasePriceCont {
    private HRSys model;
    private updBasePrice view;
    private manGui gui;
    private String name;
    private mainController cont;

    public updBasePriceCont(HRSys model, updBasePrice view, manGui gui, String name, mainController cont){
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

        this.view.addConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure?");
                double price = view.getxField();

                if (price < 100.00){
                    view.appendOutput("Invalid price. Please enter a value greater than or equal to 100:");
                    return;
                }

                if(confirmed){
                    model.updBasePrice(name, price);
                    view.appendOutput("Updated Base Price.");
                }
                else{
                    view.appendOutput("Base Pricenot Updated.");
                }

            }
        });


    }

    public void displayView(){
        view.setVisible(true);
    }

    public void setName(String name) {
        this.name = name;
    }

}

