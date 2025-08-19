import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class SessionDayFrame {
    JButton buttonDay;
    JButton buttonSession;
    ImageIcon icon;
    JFrame frame;
    public SessionDayFrame() {frame = new JFrame("Day and Session");
        icon = new ImageIcon(getClass().getResource("/notebook.png"));
        buttonDay = new JButton("new Day");
        buttonSession = new JButton("new Session");
        buttonDay.setBounds(10, 18, 100, 38);
        buttonSession.setBounds(130, 18, 150, 38);
        buttonDay.setBackground(new Color(224, 199, 153));
        buttonSession.setBackground(new Color(224, 199, 153));
        buttonDay.setFocusPainted(false);
        buttonSession.setFocusPainted(false);
        buttonDay.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonSession.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));




        frame.add(buttonDay);
        frame.add(buttonSession);
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(224, 199, 153));
        frame.setSize(300, 100);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
