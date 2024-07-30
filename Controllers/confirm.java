package Controllers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class confirm extends JDialog {
    private boolean confirmed;

    public confirm(Frame parent, String title, String message) {
        super(parent, title, true);

        // Set dialog properties
        setSize(300, 150);
        setLocationRelativeTo(parent);

        // Create message label
        JLabel messageLabel = new JLabel(message);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create buttons
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");

        // Add action listeners to buttons
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                setVisible(false);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = false;
                setVisible(false);
            }
        });

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        // Add components to dialog
        setLayout(new BorderLayout());
        add(messageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public static boolean showConfirmationDialog(Frame parent, String title, String message) {
        confirm dialog = new confirm(parent, title, message);
        dialog.setVisible(true);
        return dialog.isConfirmed();
    }
}
