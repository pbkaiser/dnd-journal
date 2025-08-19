import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class SearchFrame {
    JFrame frame;
    ImageIcon icon;
    JTextField searchField;
    JButton buttonSearch;
    JButton buttonListChar;
    JButton buttonListLocation;
    public SearchFrame() {
        frame = new JFrame("Search");
        icon = new ImageIcon(getClass().getResource("/notebook.png"));
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(224, 199, 153));
        frame.setSize(538,304);
        frame.setLayout(null);

        searchField = new JTextField("Search...");
        searchField.setBounds(38, 38, 304, 30);
        frame.add(searchField);

        buttonSearch = new JButton("Search");
        buttonSearch.setBounds(351, 34, 114, 38);
        buttonSearch.setBackground(new Color(224, 199, 153));
        buttonSearch.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        frame.add(buttonSearch);

        buttonListChar = new JButton("give a list of characters");
        buttonListLocation = new JButton("give a list of locations");
        buttonListChar.setBounds(38, 114, 465, 38);
        buttonListLocation.setBounds(38, 190, 465, 38);

        buttonListChar.setBackground(new Color(224, 199, 153));
        buttonListChar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        buttonListLocation.setBackground(new Color(224, 199, 153));
        buttonListLocation.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        frame.add(buttonListChar);
        frame.add(buttonListLocation);






        frame.setVisible(true);
    }
}
