import javax.swing.*;
import java.awt.event.*;

public class DeleteFrame {
    JFrame frame;
    ImageIcon icon;
    public DeleteFrame() {
        frame = new JFrame("Delete");
        icon = new ImageIcon(getClass().getResource("/notebook.png"));
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Beispiel-Elemente
        for (int i = 1; i <= 20; i++) {
            listModel.addElement("Charakter " + i);
        }

        JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Scrollpane hinzufügen
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);

        // Klick-Listener, um Elemente zu löschen
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doppelklick
                    int index = list.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        String item = listModel.getElementAt(index);
                        int confirm = JOptionPane.showConfirmDialog(frame,
                                "Willst du '" + item + "' löschen?",
                                "Löschen bestätigen",
                                JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            listModel.remove(index);
                        }
                    }
                }
            }
        });

        frame.setLocationRelativeTo(null); // Mitte des Bildschirms
        frame.setVisible(true);
    }
}

