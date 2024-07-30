package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class addRoom extends JFrame {
    private JButton GoBack;
    private JTextField addRoom;
    private JButton addRoomBut;
    private JButton std;
    private JButton del;
    private JButton exe;
    private JTextArea outputArea;

    public addRoom(){
        setTitle("Hotel Reservation System - Add Room");
        setSize(600,500);
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
        JLabel title = new JLabel("   Add Room");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));
        
        ////////////////////


        addRoom = new JTextField();
        addRoomBut = new JButton("Add Rooms");
        
        
        // OUTPUT AREA
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setPreferredSize(new Dimension(600, 100));

        //////////////////////

        std = new JButton("Standard Room");
        del = new JButton("Deluxe Room");
        exe = new JButton("Executive Room");

        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(6,3, 10, 10));
        CenterPanel.add(new JPanel());

        
        CenterPanel.add(new JPanel());
        JPanel Middle = new JPanel();
        Middle.setLayout(new GridLayout(3,2));
        Middle.add(new JLabel("How many rooms:"));
        Middle.add(new JPanel());
        Middle.add(new JPanel());
        Middle.add(addRoom);
        Middle.add(addRoomBut);

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new GridLayout(1,7));
        Bottom.add(outputScrollPane);        

        CenterPanel.add(Middle);
        CenterPanel.add(std);
        CenterPanel.add(del);
        CenterPanel.add(exe);
        CenterPanel.add(Bottom);
        CenterPanel.add(new JPanel());

        

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

    public void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    public String getStdRooms(){
        return addRoom.getText();
    }

    public void addStdButListener(ActionListener listenForAddStdBut){
        addRoomBut.addActionListener(listenForAddStdBut);
    }

    public void addStdListener(ActionListener listenForStd){
        std.addActionListener(listenForStd);
    }

    public void addDelListener(ActionListener listenForDel){
        del.addActionListener(listenForDel);
    }

    public void addExeListener(ActionListener listenForExe){
        exe.addActionListener(listenForExe);
    }

}

   