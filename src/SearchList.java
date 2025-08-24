import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchList {
    JFrame frame;
    ImageIcon icon;
    DefaultListModel<String> listModel;
    JList<String> list;
    public SearchList() {
        frame = new JFrame("Characters");
        icon = new ImageIcon(getClass().getResource("/notebook.png"));
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 400);

        listModel = new DefaultListModel<>();

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Scrollpane hinzufügen
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);
        frame.getContentPane().setBackground(new Color(224, 199, 153));
        list.setBackground(new Color(224, 199, 153)); // Hintergrund
        list.setForeground(Color.BLACK);

        frame.setLocationRelativeTo(null); // Mitte des Bildschirms
        frame.setVisible(true);
    }
}

