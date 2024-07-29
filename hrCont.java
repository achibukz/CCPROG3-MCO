import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hrCont {
    private HRSys model;
    private HRGui view;

    public hrCont(HRSys model, HRGui view){
        this.model = model;
        this.view = view;
    }

    public void displayView(){
        view.setVisible(true);
    }

}

