package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.HRSys;
import Views.dataPrice;
import Views.manGui;

public class dataPriceCont {
    private HRSys model;
    private dataPrice view;
    private manGui gui;
    private String name;

    public dataPriceCont(HRSys model, dataPrice view, manGui gui, String name){
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
                boolean confirmed = confirm.showConfirmationDialog(view, "Confirm", "Are you sure?");
                int date = view.getxField();
                double disc = view.getyField();

                if (date < 1 || date > 31){
                    view.appendOutput("Invalid date.");
                    return;
                }

                if (disc < 0.5 || disc > 1.5){
                    view.appendOutput("Invalid price.");
                    return;
                }

                if(confirmed){
                    model.updateDisc(name, date, disc);
                    view.appendOutput("Updated Discount.");
                }
                else{
                    view.appendOutput("Discount not Updated.");
                }

            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

    public void updateOutput(){
        view.appendOutput("Choose the number of the day:");
        view.appendOutput("Use decimals from 0.5 to 1.5:");

        for (int i = 0; i < 31; i++){
            view.appendOutput("Day " + (i + 1));
        }
    }

}

