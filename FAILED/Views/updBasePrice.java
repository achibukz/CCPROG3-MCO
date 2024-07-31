package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class updBasePrice extends JFrame {
    private JButton GoBack;
    private JTextArea outputArea;
    private JTextField xField;
    private JButton confirm;

    public updBasePrice(){
        setTitle("Hotel Reservation System - Update Base Price");
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
        JLabel title = new JLabel("   Update Base Price");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(5, 50));

        ////////////////////

        

        // OUTPUT AREA
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setPreferredSize(new Dimension(600, 100));

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new GridLayout(1,7));
        Bottom.add(outputScrollPane);  

        //////////////////////

        // CENTER
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new GridLayout(2,1,10,10));

        ////////////////////

        /////
        JPanel CenterPanel2 = new JPanel();
        CenterPanel2.setLayout(new GridLayout(4,2,10,10));
        CenterPanel2.add(new JPanel());
        CenterPanel2.add(new JPanel());
        CenterPanel2.add(new JLabel("New Price: "));
        xField = new JTextField();
        CenterPanel2.add(xField);
        CenterPanel2.add(new JPanel());

        confirm = new JButton("Confirm");
        CenterPanel2.add(confirm); 

        CenterPanel.add(CenterPanel2);
        CenterPanel.add(Bottom);

        ///////////


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

    public double getxField(){
        return Double.parseDouble(xField.getText());
    }

    public void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }



}

   