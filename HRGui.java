import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionListener;


public class HRGui extends JFrame {
    private JButton GoBack;
    private JTextArea outputArea;

    public HRGui(){
        setTitle("Hotel Reservation System - Main");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GoBack = new JButton("Go Back");
        JPanel NorthPanel = new JPanel();

        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   Hotel Reservation System");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));
        
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(4,1));

        JPanel ViewHotel = new JPanel();
        ViewHotel.add(new JLabel("View Hotel"));
        JPanel ManageHotel = new JPanel();
        ManageHotel.add(new JLabel("Manage Hotel"));
        JPanel BookRoom = new JPanel();
        BookRoom.add(new JLabel("Book Room"));

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        CenterPanel.add(ViewHotel);
        CenterPanel.add(ManageHotel);
        CenterPanel.add(BookRoom);
        CenterPanel.add(outputArea);

        JPanel EastPanel = new JPanel();
        EastPanel.setLayout(new GridLayout(7,1,10,10));
        EastPanel.setPreferredSize(new Dimension(85, 10));

        for (int i = 0; i < 6; i++){
            EastPanel.add(new JPanel());
        }
        EastPanel.add(GoBack); // Add the GoBack button in the 7th row

        JPanel WestPanel = new JPanel();
        WestPanel.setLayout(new GridLayout(7,1,10,10));
        WestPanel.setPreferredSize(new Dimension(50, 10));


        add(NorthPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
        add(WestPanel, BorderLayout.WEST);
        add(EastPanel, BorderLayout.EAST);
    }

    public void addGoBackListener(ActionListener listenForGoBack){
        GoBack.addActionListener(listenForGoBack);
    }


}

   