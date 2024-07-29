import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;


public class HRGui extends JFrame {

    public HRGui(){
        JLabel title = new JLabel("Hotel Reservation System");
        setTitle("Hotel Reservation System");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,1, 10, 10));
        
        add(title);

    }
}

   