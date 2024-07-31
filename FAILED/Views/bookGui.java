package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class bookGui extends JFrame {
    private JButton GoBack;
    private JTextArea outputArea;
    private JTextField name;
    private JTextField CheckIn;
    private JTextField CheckOut;
    private JTextField discountCode;
    private JTextField roomID;
    private JButton confirm;

    public bookGui(){
        setTitle("Hotel Reservation System - Book a Room");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GoBack = new JButton("Go Back");
        JPanel NorthPanel = new JPanel();

        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   Book a Room");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));

        JPanel EastPanel = new JPanel();
        EastPanel.setLayout(new GridLayout(7,1,10,10));
        EastPanel.setPreferredSize(new Dimension(85, 10));

        for (int i = 0; i < 6; i++){
            EastPanel.add(new JPanel());
        }
        EastPanel.add(GoBack); // Add the GoBack button in the 7th row

        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(1,2, 20, 20));
        JPanel CenterPanel1 = new JPanel();
        JPanel CenterPanel2 = new JPanel();
        CenterPanel1.setLayout(new GridLayout(3,1));
        CenterPanel2.setLayout(new GridLayout(20,2));

        JLabel roomTitle = new JLabel("Choose a Room:");
        roomTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        CenterPanel1.add(roomTitle);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setPreferredSize(new Dimension(600, 200));
        CenterPanel1.add(outputScrollPane);
        
        

        // CentralPanel2
        CenterPanel2.add(new JLabel("Guest Name:"));
        name = new JTextField();
        CenterPanel2.add(name);
        CenterPanel2.add(new JLabel("Room ID:"));
        roomID = new JTextField();
        CenterPanel2.add(roomID);
        CenterPanel2.add(new JLabel("Check In Date:"));
        CheckIn = new JTextField();
        CenterPanel2.add(CheckIn);
        CenterPanel2.add(new JLabel("Check Out Date:"));
        CheckOut = new JTextField();
        CenterPanel2.add(CheckOut);
        CenterPanel2.add(new JLabel("Discount Code:"));
        discountCode = new JTextField();
        CenterPanel2.add(discountCode);
        confirm = new JButton("Confirm");
        CenterPanel2.add(new JPanel());
        CenterPanel2.add(confirm);

        CenterPanel.add(CenterPanel1);
        CenterPanel.add(CenterPanel2);

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

    public void addConfirmListener(ActionListener listenForConfirm){
        confirm.addActionListener(listenForConfirm);
    }

    public String getName(){
        return name.getText();
    }

    public int getCheckIn(){
        return Integer.parseInt(CheckIn.getText());
    }

    public int getCheckOut(){
        return Integer.parseInt(CheckOut.getText());
    }
    public String getDiscountCode(){
        return discountCode.getText();
    }

    public String getRoomID(){
        return roomID.getText();
    }




    public void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

}

   