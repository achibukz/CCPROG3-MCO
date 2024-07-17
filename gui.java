import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class gui {
    
    public gui(){
        JFrame frame = new JFrame("Hotel Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        JLabel titleLabel = new JLabel("Hotel Reservation System");
        titleLabel.setFont(new Font("Karla", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        frame.getContentPane().add(titleLabel, BorderLayout.NORTH);

        // Create a JButton
        JButton myButton = new JButton("Open Program");
        // Add ActionListener to JButton
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the function to be executed when the button is clicked
                driver d = new driver();
                d.displayMenu();
            }
        });

        // Create a panel with FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        // Add the JButton to the panel
        buttonPanel.add(myButton);
        // Set the preferred size of the JButton
        myButton.setPreferredSize(new Dimension(100, 50));
        // Set the position of the button
        buttonPanel.setLocation(100, 200);
        
        // Add the button panel to the frame's content pane
        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);


        

        frame.setVisible(true);
    }



    public static void main(String[] args) {
        new gui();
    }


}
