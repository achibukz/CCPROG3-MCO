package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class manGui extends JFrame {
    private JButton GoBack;
    private JTextArea outputArea;

    private JButton updHotelBut;
    private JButton addRoomBut;
    private JButton remRoomBut;
    private JButton updBasePriceBut;
    private JButton remResBut;
    private JButton remHotBut;
    private JButton dataPriceBut;

    public manGui(){
        setTitle("Hotel Reservation System - Manage a Hotel");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GoBack = new JButton("Go Back");
        updHotelBut = new JButton("Update Hotel Name");
        addRoomBut = new JButton("Add a Room");
        remRoomBut = new JButton("Remove a Room");
        updBasePriceBut = new JButton("Update Base Price");
        remResBut = new JButton("Remove a Reservation");
        remHotBut = new JButton("Remove Hotel");
        dataPriceBut = new JButton("Data Price Modifier");

        JPanel NorthPanel = new JPanel();

        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   Manage a hotel");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));
        
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(6,2, 20, 20));
        CenterPanel.add(new JPanel());
        CenterPanel.add(new JPanel());
        CenterPanel.add(updHotelBut);
        CenterPanel.add(addRoomBut);
        CenterPanel.add(remRoomBut);
        CenterPanel.add(updBasePriceBut);
        CenterPanel.add(remResBut);
        CenterPanel.add(remHotBut);
        CenterPanel.add(dataPriceBut);

        
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

    public void addUpdHotelListener(ActionListener listenForUpdHotel){
        updHotelBut.addActionListener(listenForUpdHotel);
    }

    public void addAddRoomListener(ActionListener listenForAddRoom){
        addRoomBut.addActionListener(listenForAddRoom);
    }

    public void addRemRoomListener(ActionListener listenForRemRoom){
        remRoomBut.addActionListener(listenForRemRoom);
    }

    public void addUpdBasePriceListener(ActionListener listenForUpdBasePrice){
        updBasePriceBut.addActionListener(listenForUpdBasePrice);
    }

    public void addRemResListener(ActionListener listenForRemRes){
        remResBut.addActionListener(listenForRemRes);
    }

    public void addRemHotListener(ActionListener listenForRemHot){
        remHotBut.addActionListener(listenForRemHot);
    }

    public void addDataPriceListener(ActionListener listenForDataPrice){
        dataPriceBut.addActionListener(listenForDataPrice);
    }


}

   