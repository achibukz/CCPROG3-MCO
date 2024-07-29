import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class creCont {
    private HRSys model;
    private createGUI view;

    public creCont(HRSys model, createGUI view){
        this.model = model;
        this.view = view;

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
                    HRGui gui = new HRGui();
                    hrCont cont = new hrCont(model, gui, view);
                    cont.displayView();
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

}

