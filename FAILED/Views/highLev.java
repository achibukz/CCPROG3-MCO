package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import Controllers.highLevCont;


public class highLev extends JFrame {
    private JButton GoBack;
    private JTextField nameArea;
    private JTextField roomsArea;
    private JTextField earningsArea;

    public highLev(){
        setTitle("Hotel Reservation System - High Level Information");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GoBack = new JButton("Go Back");
        JPanel NorthPanel = new JPanel();

        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   High Level Information");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));
        
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(3,1, 10, 10));
        CenterPanel.add(new JPanel());

        nameArea = new JTextField(20);
        nameArea.setEditable(false);
        roomsArea = new JTextField(20);
        roomsArea.setEditable(false);
        earningsArea = new JTextField(20);
        earningsArea.setEditable(false);

        
        JPanel Middle = new JPanel();
        Middle.setLayout(new GridLayout(3,2));
        Middle.add(new JLabel("Hotel Name: "));
        Middle.add(nameArea);
        Middle.add(new JPanel());
        Middle.add(new JLabel("Number of Rooms: "));
        Middle.add(roomsArea);
        Middle.add(new JPanel());
        Middle.add(new JLabel("Estimated Earnings: "));
        Middle.add(earningsArea);

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new GridLayout(1,7));
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        

        CenterPanel.add(Middle);
        CenterPanel.add(new JPanel());

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

    public void setHotName(String name){
        nameArea.setText(name);
    }

    public void setHotRooms(int rooms){
        roomsArea.setText(Integer.toString(rooms));
    }

    public void setHotEarnings(double earnings){
        earningsArea.setText(Double.toString(earnings));
    }



}

   