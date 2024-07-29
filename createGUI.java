import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;



public class createGUI extends JFrame {
    private JButton creHotelBut;
    private JButton nextWindowBut;
    private JTextArea outputArea;

    private JTextField hotelNameField;
    private JSlider stdRoomSlider;
    private JSlider delRoomSlider;
    private JSlider execRoomSlider;
    private JLabel totalRoomsLabel;


    public createGUI(){
        setTitle("Hotel Reservation System - Create Hotel");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new GridLayout(1,1, 10, 10));
        setLayout(new BorderLayout());
        creHotelBut = new JButton("Create a hotel");
        creHotelBut.setPreferredSize(new Dimension(50, 50));
        nextWindowBut = new JButton("Next Window");
        nextWindowBut.setPreferredSize(new Dimension(50, 50));


        hotelNameField = new JTextField();
        stdRoomSlider = new JSlider(0, 50, 0);
        delRoomSlider = new JSlider(0, 50, 0);
        execRoomSlider = new JSlider(0, 50, 0);
        totalRoomsLabel = new JLabel("Total rooms: 0");

        JPanel CenterPanel = new JPanel();

        JPanel butPanel = new JPanel();
        butPanel.setLayout(new GridLayout(1,2, 50, 50));
        butPanel.add(creHotelBut);
        butPanel.add(nextWindowBut);


        JPanel inputPanel = new JPanel(new GridLayout(7,2));
        inputPanel.add(new JLabel("Hotel Name:"));
        inputPanel.add(hotelNameField);
        inputPanel.add(new JLabel("Standard Rooms:"));
        inputPanel.add(stdRoomSlider);
        inputPanel.add(new JLabel("Deluxe Rooms:"));
        inputPanel.add(delRoomSlider);
        inputPanel.add(new JLabel("Executive Rooms:"));
        inputPanel.add(execRoomSlider);
        inputPanel.add(totalRoomsLabel);
        inputPanel.add(new JLabel(""));

        // CenterPanel.setBackground(Color.ORANGE);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        stdRoomSlider.setMajorTickSpacing(10);
        stdRoomSlider.setMinorTickSpacing(1);
        stdRoomSlider.setPaintTicks(true);
        stdRoomSlider.setPaintLabels(true);

        delRoomSlider.setMajorTickSpacing(10);
        delRoomSlider.setMinorTickSpacing(1);
        delRoomSlider.setPaintTicks(true);
        delRoomSlider.setPaintLabels(true);

        execRoomSlider.setMajorTickSpacing(10);
        execRoomSlider.setMinorTickSpacing(1);
        execRoomSlider.setPaintTicks(true);
        execRoomSlider.setPaintLabels(true);

        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int totalRooms = stdRoomSlider.getValue() + delRoomSlider.getValue() + execRoomSlider.getValue();
                if (totalRooms > 50){
                    JSlider source = (JSlider)e.getSource();
                    source.setValue(source.getValue() - (totalRooms - 50));
                    totalRooms = 50;
                }
                totalRoomsLabel.setText("Total rooms: " + totalRooms);
            }
        };

        stdRoomSlider.addChangeListener(listener);
        delRoomSlider.addChangeListener(listener);
        execRoomSlider.addChangeListener(listener);

        butPanel.setMaximumSize(new Dimension(10, 10));
        outputArea.setPreferredSize(new Dimension(600, 100));

        CenterPanel.setLayout(new BorderLayout(50,50));
        CenterPanel.add(inputPanel, BorderLayout.NORTH);
        CenterPanel.add(butPanel, BorderLayout.CENTER);
        CenterPanel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);
        
        JPanel NorthPanel = new JPanel();
        NorthPanel.setLayout(new GridLayout(1,1));
        JLabel title = new JLabel("   Create a Hotel");
        title.setFont(new Font("Arial", Font.PLAIN, 32));
        NorthPanel.add(title);
        NorthPanel.setPreferredSize(new Dimension(10, 100));

        JPanel WestPanel = new JPanel();
        WestPanel.setPreferredSize(new Dimension(100, 100));
        WestPanel.setLayout(new GridLayout(1,1));
        JPanel EastPanel = new JPanel();
        EastPanel.setPreferredSize(new Dimension(100, 100));
        EastPanel.setLayout(new GridLayout(1,1));
        
        add(NorthPanel, BorderLayout.NORTH);
        add(WestPanel, BorderLayout.WEST);
        add(EastPanel, BorderLayout.EAST);
        add(CenterPanel, BorderLayout.CENTER);
    }

    public JButton getCreHotelBut(){
        return creHotelBut;
    }

    public JButton getNextWindowBut(){
        return nextWindowBut;
    }

    public String getHotelName(){
        return hotelNameField.getText();
    }

    public int getStdRooms(){
        return stdRoomSlider.getValue();
    }

    public int getDelRooms(){
        return delRoomSlider.getValue();
    }

    public int getExecRooms(){
        return execRoomSlider.getValue();
    }

    public void appendOutput(String text){
        outputArea.append(text + "\n");
    }

    public void addCHL(ActionListener listener){
        creHotelBut.addActionListener(listener);
    }

    public void nextWindow(ActionListener listener){
        nextWindowBut.addActionListener(listener);
    }

}
