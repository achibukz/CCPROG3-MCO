package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class lowLev extends JFrame {
    private JButton GoBack;
    private JTextArea outputArea;

    public lowLev(){
        setTitle("Hotel Reservation System - Low Level Information");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GoBack = new JButton("Go Back");
        JPanel NorthPanel = new JPanel();

        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   Low Level Information");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));
        
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(6,1, 10, 10));
        CenterPanel.add(new JPanel());

        
        CenterPanel.add(new JPanel());
        JPanel Middle = new JPanel();
        Middle.setLayout(new GridLayout(1,9));
        Middle.add(new JPanel());
        Middle.add(new JPanel());
        Middle.add(new JPanel());
        Middle.add(new JPanel());
        Middle.add(new JPanel());

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new GridLayout(1,7));
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        Bottom.add(new JPanel());
        

        CenterPanel.add(Bottom);
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


}

   