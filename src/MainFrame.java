import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
public class MainFrame {

    private ImageIcon icon = new ImageIcon(getClass().getResource("/notebook.png"));
    private ImageIcon plusIcon = new ImageIcon(getClass().getResource("/plus.png"));
    private ImageIcon lupeIcon = new ImageIcon(getClass().getResource("/lupe.png"));
    private ImageIcon sonneMondIcon = new ImageIcon(getClass().getResource("/tag.png"));
    private ImageIcon sternIcon = new ImageIcon(getClass().getResource("/stern.png"));
    private JTextArea textArea;
    private JTextField textField;
    private JScrollPane scrollPane;
    private JButton buttonPlus;
    private JButton buttonLupe;
    private JButton buttonTag;
    private JButton buttonStern;
    MainFrame() {
        frame();
    }
    private void frame() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);

        textField = new JTextField("type here");

        plusIcon.setImage(plusIcon.getImage().getScaledInstance(76, 76, Image.SCALE_SMOOTH));
        buttonPlus = new JButton(plusIcon);
        buttonPlus.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        lupeIcon.setImage(lupeIcon.getImage().getScaledInstance(76, 76, Image.SCALE_SMOOTH));
        buttonLupe = new JButton(lupeIcon);
        buttonLupe.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        sonneMondIcon.setImage(sonneMondIcon.getImage().getScaledInstance(76, 76, Image.SCALE_SMOOTH));
        buttonTag = new JButton(sonneMondIcon);
        buttonTag.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        sternIcon.setImage(sternIcon.getImage().getScaledInstance(76, 76, Image.SCALE_SMOOTH));
        buttonStern = new JButton(sternIcon);
        buttonStern.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JFrame frame = new JFrame("DnD Journal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(538,600);
        frame.setLayout(null);


        buttonPlus.setBounds(38, 38, 76, 76);
        buttonLupe.setBounds(152, 38, 76, 76);
        buttonStern.setBounds(264, 38, 76, 76);
        buttonTag.setBounds(380, 38, 76, 76);
        scrollPane.setBounds(38, 200, 418, 300);
        textField.setBounds(38, 500, 418, 20);

        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(224, 199, 153));
        frame.add(buttonPlus);
        frame.add(buttonLupe);
        frame.add(buttonTag);
        frame.add(buttonStern);
        frame.add(scrollPane);
        frame.add(textField);
        frame.setVisible(true);

    }
    public JButton getButtonPlus() {
        return buttonPlus;
    }
    public JButton getButtonLupe() {
        return buttonLupe;
    }
    public JButton getButtonTag() {
        return buttonTag;
    }
    public JButton getButtonStern() {
        return buttonStern;
    }
    public JTextField getTextField() {
        return textField;
    }
    public void setTextArea(String text) {
        textArea.append(text + "\n");
    }

}
