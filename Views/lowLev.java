package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class lowLev extends JFrame {
    private JButton GoBack;
    private JTextArea outputArea1;
    private JTextArea outputArea2;
    private JTextArea outputArea3;

    public lowLev(){
        setTitle("Hotel Reservation System - Low Level Information");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // GO BACK BUTTON
        GoBack = new JButton("Go Back");

        JPanel EastPanel = new JPanel();
        EastPanel.setLayout(new GridLayout(7,1,10,10));
        EastPanel.setPreferredSize(new Dimension(85, 10));

        for (int i = 0; i < 6; i++){
            EastPanel.add(new JPanel());
        }
        EastPanel.add(GoBack); // Add the GoBack button in the 7th row

        /////////////////////


        // TITLE
        JPanel NorthPanel = new JPanel();

        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   Low Level Information");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));

        ////////////////////

       

        //CENTER
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(1,3, 20, 20));

        JPanel CenterPanel1 = new JPanel();
        CenterPanel1.setLayout(new GridLayout(3,1));

        JPanel CenterPanel2 = new JPanel();
        CenterPanel2.setLayout(new GridLayout(3,1));

        JPanel CenterPanel3 = new JPanel();
        CenterPanel3.setLayout(new GridLayout(3,1));

         // OUTPUT AREA
         outputArea1 = new JTextArea();
         outputArea1.setEditable(false);
         outputArea1.setLineWrap(true);
         outputArea1.setWrapStyleWord(true);
 
         JScrollPane outputScrollPane1 = new JScrollPane(outputArea1);
         outputScrollPane1.setPreferredSize(new Dimension(600, 100));
 

          // OUTPUT AREA
        outputArea2 = new JTextArea();
        outputArea2.setEditable(false);
        outputArea2.setLineWrap(true);
        outputArea2.setWrapStyleWord(true);

        JScrollPane outputScrollPane2 = new JScrollPane(outputArea2);
        outputScrollPane2.setPreferredSize(new Dimension(600, 100));


         // OUTPUT AREA
         outputArea3 = new JTextArea();
         outputArea3.setEditable(false);
         outputArea3.setLineWrap(true);
         outputArea3.setWrapStyleWord(true);
 
         JScrollPane outputScrollPane3 = new JScrollPane(outputArea3);
         outputScrollPane3.setPreferredSize(new Dimension(600, 100));  
 
         //////////////////////

        CenterPanel1.add(new JLabel("Availability of Rooms: "));
        CenterPanel1.add(outputScrollPane1);
        CenterPanel1.add(new JLabel(""));

        CenterPanel2.add(new JLabel("Rooms Information: "));
        CenterPanel2.add(outputScrollPane2);
        CenterPanel2.add(new JLabel(""));

        CenterPanel3.add(new JLabel("All Reservations: "));
        CenterPanel3.add(outputScrollPane3);
        CenterPanel3.add(new JLabel(""));

        CenterPanel.add(CenterPanel1);
        CenterPanel.add(CenterPanel2);
        CenterPanel.add(CenterPanel3);



        // WEST

        JPanel WestPanel = new JPanel();
        WestPanel.setLayout(new GridLayout(7,1,10,10));
        WestPanel.setPreferredSize(new Dimension(50, 10));

        //////////////////////


        add(NorthPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
        add(WestPanel, BorderLayout.WEST);
        add(EastPanel, BorderLayout.EAST);
    }

    public void addGoBackListener(ActionListener listenForGoBack){
        GoBack.addActionListener(listenForGoBack);
    }

    public void appendOutput1(String text){
        outputArea1.append(text + "\n");
    }

    public void appendOutput2(String text){
        outputArea2.append(text + "\n");
    }

    public void appendOutput3(String text){
        outputArea3.append(text + "\n");
    }

}

   