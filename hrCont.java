import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hrCont {
    private HRSys model;
    private HRGui view;
    private createGUI gui;

    public hrCont(HRSys model, HRGui view, createGUI gui){
        this.model = model;
        this.view = view;
        this.gui = gui;

        this.view.addGoBackListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                gui.setVisible(true); // Show the previous createGUI instance
            }
        });
    }

    public void displayView(){
        view.setVisible(true);
    }

}

