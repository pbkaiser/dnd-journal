import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class AddFrame {
    JFrame frame;
    ImageIcon icon;
    JButton buttonChar;
    JButton buttonLocation;
    JTextArea charDescription;
    JTextArea locationDescription;
    JTextField nameChar;
    JTextField nameLocation;
    JCheckBox favChar;
    JCheckBox favLocation;

    public AddFrame() {
        frame = new JFrame("Add");
        icon = new ImageIcon(getClass().getResource("/notebook.png"));
        buttonChar = new JButton("Add");
        buttonLocation = new JButton("Add");
        favChar = new JCheckBox("Favorite");
        favLocation = new JCheckBox("Favorite");
        buttonChar.setBounds(420, 165, 76, 38);
        buttonLocation.setBounds(420, 360, 76, 38);
        buttonChar.setBackground(new Color(224, 199, 153));
        buttonLocation.setBackground(new Color(224, 199, 153));
        favChar.setBounds(18, 165, 80, 30);
        favChar.setBackground(new Color(224, 199, 153));
        favLocation.setBounds(18, 360, 80, 30);
        favLocation.setBackground(new Color(224, 199, 153));
        favChar.setFocusPainted(false);
        favLocation.setFocusPainted(false);
        buttonChar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonLocation.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        charDescription = new JTextArea("Character description");
        locationDescription = new JTextArea("Location description");
        charDescription.setBounds(18, 87, 480, 76);
        locationDescription.setBounds(18, 280, 480, 76);
        charDescription.setBackground(new Color(224, 199, 153));
        locationDescription.setBackground(new Color(224, 199, 153));
        charDescription.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        locationDescription.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        frame.add(charDescription);
        frame.add(locationDescription);


        frame.add(buttonChar);
        frame.add(buttonLocation);
        nameChar = new JTextField("name of character");
        nameLocation = new JTextField("name of location");
        nameLocation.setBounds(18, 245, 480, 30);
        nameLocation.setBackground(new Color(224, 199, 153));
        nameChar.setBounds(18, 46, 480, 30);
        nameChar.setBackground(new Color(224, 199, 153));
        JLabel labelChar = new JLabel("Character:");
        JLabel labelLocation = new JLabel("Location:");
        labelChar.setBounds(18, 8, 76, 38);
        labelLocation.setBounds(18, 205, 76, 38);
        frame.add(labelChar);
        frame.add(labelLocation);
        frame.add(nameChar);
        frame.add(nameLocation);
        frame.add(favChar);
        frame.add(favLocation);


        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(224, 199, 153));
        frame.setSize(518, 450);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
