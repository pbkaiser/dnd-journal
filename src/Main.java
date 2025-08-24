import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    MainFrame mainFrame;
    SearchFrame searchFrame;
    SessionDayFrame sessionDayFrame;
    DeleteFrame deleteFrame;
    Admin admin;
    SearchList searchList;
    AddFrame addFrame;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        admin = LoadManager.loadAdmin("admin.dat");
        //admin = new Admin();
        mainFrame = new MainFrame();
        mainFrame.getButtonPlus().addActionListener(this::actionPerformed);
        mainFrame.getButtonLupe().addActionListener(this::actionPerformed);
        mainFrame.getButtonStern().addActionListener(this::actionPerformed);
        mainFrame.getButtonTag().addActionListener(this::actionPerformed);
        mainFrame.getTextField().addActionListener(this::actionPerformed);
        mainFrame.buttonDelete.addActionListener(this::actionPerformed);
        mainFrame.buttonRecap.addActionListener(this::actionPerformed);
        mainFrame.buttonSave.addActionListener(this::actionPerformed);
        mainFrame.buttonNotebook.addActionListener(this::actionPerformed);
        mainFrame.frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                SaveManager.saveAdmin(admin, "admin.dat");
                System.exit(0);
            }
        });
    }

    private void setLast(String name) {
        for (int i = 0; i < admin.getCharacters().size(); i++) {
            admin.getCharacters().get(i).setLast(false);
        }
        for (int i = 0; i < admin.getCharacters().size(); i++) {
            if (admin.getCharacters().get(i).getName().equals(name)) {
                admin.getCharacters().get(i).setLast(true);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainFrame.buttonNotebook) {
            for (Entry entry : admin.getEntries()) {
                if (entry.getSession() == admin.getSession() - 1) {
                    mainFrame.setTextArea(entry.toString());
                }
            }
        }
        if (e.getSource() == mainFrame.buttonDelete) {
            deleteFrame = new DeleteFrame();
            deleteFrame.frame.setLocation(mainFrame.frame.getX() + mainFrame.frame.getWidth() + 10, mainFrame.frame.getY());
            for (Entity entity : admin.getCharacters()) {
                deleteFrame.listModel.addElement(entity.getName());
            }
            deleteFrame.list.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) { // Doppelklick
                        int index = deleteFrame.list.locationToIndex(e.getPoint());
                        if (index >= 0) {
                            UIManager.put("OptionPane.background", new Color(224, 199, 153));
                            UIManager.put("Panel.background", new Color(224, 199, 153));
                            UIManager.put("OptionPane.messageForeground", Color.DARK_GRAY);
                            UIManager.put("Button.background", new Color(224, 199, 153));
                            UIManager.put("Button.foreground", Color.BLACK);

                            String item = deleteFrame.listModel.getElementAt(index);
                            int confirm = JOptionPane.showConfirmDialog(deleteFrame.frame, "delete '" + item + "' ?", "confirm delete", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                deleteFrame.listModel.remove(index);

                                for (int i = 0; i < admin.getCharacters().size(); i++) {
                                    if (admin.getCharacters().get(i).getName().equals(item)) {
                                        admin.getCharacters().remove(i);
                                        i--;
                                    }
                                }
                            }
                        }
                    }
                }
            });


        }
        if (e.getSource() == mainFrame.buttonRecap) {
            mainFrame.clearTextArea();
        }

        if (e.getSource() == mainFrame.buttonSave) {
            SaveManager.saveAdmin(admin, "admin.dat");
            mainFrame.setTextArea("Saved.");
        }
        if (e.getSource() == mainFrame.getButtonPlus()) {
            addFrame = new AddFrame();
            addFrame.frame.setLocation(mainFrame.frame.getX() + mainFrame.frame.getWidth() + 10,  // 20px rechts daneben
                    mainFrame.frame.getY()                               // gleiche Höhe
            );

            addFrame.buttonChar.addActionListener(ev -> {
                admin.addCharacter(new Entity(addFrame.nameChar.getText()));
                admin.getCharacters().get(admin.getCharacters().size() - 1).addEntry(new Entry(addFrame.charDescription.getText(), admin.getDay(), admin.getSession()));
                admin.getCharacters().get(admin.getCharacters().size() - 1).setFav(addFrame.favChar.isSelected());
                admin.addEntry(new Entry(addFrame.nameChar.getText() + ": " + addFrame.charDescription.getText(), admin.getDay(), admin.getSession()));
                addFrame.frame.dispose();
                mainFrame.setTextArea(admin.getEntries().get(admin.getEntries().size() - 1).toString());
                setLast(admin.getCharacters().get(admin.getCharacters().size() - 1).getName()); //hier der test
            });
            addFrame.buttonLocation.addActionListener(ev -> {
                admin.addLocation(new Entity(addFrame.nameLocation.getText()));
                admin.getLocations().get(admin.getLocations().size() - 1).addEntry(new Entry(addFrame.locationDescription.getText(), admin.getDay(), admin.getSession()));
                admin.getLocations().get(admin.getLocations().size() - 1).setFav(addFrame.favLocation.isSelected());
                admin.addEntry(new Entry(addFrame.nameLocation.getText() + ": " + addFrame.locationDescription.getText(), admin.getDay(), admin.getSession()));
                addFrame.frame.dispose();
                mainFrame.setTextArea(admin.getEntries().get(admin.getEntries().size() - 1).toString());
            });
        }
        if (e.getSource() == mainFrame.getButtonLupe()) {
            searchFrame = new SearchFrame();
            searchFrame.frame.setLocation(mainFrame.frame.getX() + mainFrame.frame.getWidth() + 10,  // 20px rechts daneben
                    mainFrame.frame.getY()                               // gleiche Höhe
            );

            searchFrame.buttonListChar.addActionListener(ev -> {
                searchList = new SearchList();
                for (Entity entity : admin.getCharacters()) {
                    searchList.listModel.addElement(entity.getName());
                }
                searchList.list.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) { // Doppelklick
                            int index = searchList.list.locationToIndex(e.getPoint());
                            if (index >= 0) {
                                UIManager.put("OptionPane.background", new Color(224, 199, 153));
                                UIManager.put("Panel.background", new Color(224, 199, 153));
                                UIManager.put("OptionPane.messageForeground", Color.DARK_GRAY);
                                UIManager.put("Button.background", new Color(224, 199, 153));
                                UIManager.put("Button.foreground", Color.BLACK);
                                String item = searchList.listModel.getElementAt(index);
                                int confirm = JOptionPane.showConfirmDialog(searchList.frame, "show '" + item + "' ?", "", JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {

                                    for (int i = 0; i < admin.getCharacters().size(); i++) {
                                        if (admin.getCharacters().get(i).getName().equals(item)) {
                                            mainFrame.setTextArea(admin.getCharacters().get(i).toString());
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                });

            });
            searchFrame.buttonListLocation.addActionListener(ev -> {
                searchList = new SearchList();
                for (Entity entity : admin.getLocations()) {
                    searchList.listModel.addElement(entity.getName());
                }
                searchList.list.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) { // Doppelklick
                            int index = searchList.list.locationToIndex(e.getPoint());
                            if (index >= 0) {
                                UIManager.put("OptionPane.background", new Color(224, 199, 153));
                                UIManager.put("Panel.background", new Color(224, 199, 153));
                                UIManager.put("OptionPane.messageForeground", Color.DARK_GRAY);
                                UIManager.put("Button.background", new Color(224, 199, 153));
                                UIManager.put("Button.foreground", Color.BLACK);
                                String item = searchList.listModel.getElementAt(index);
                                int confirm = JOptionPane.showConfirmDialog(searchList.frame, "show '" + item + "' ?", "", JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {

                                    for (int i = 0; i < admin.getLocations().size(); i++) {
                                        if (admin.getLocations().get(i).getName().equals(item)) {
                                            mainFrame.setTextArea(admin.getLocations().get(i).toString());
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                });

            });
            searchFrame.buttonSearch.addActionListener(ev -> {
                String searchword = searchFrame.searchField.getText();
                int charFound = 0;
                int locFound = 0;
                int elseFound = 0;
                mainFrame.setTextArea("Searching for " + searchword + "...");
                mainFrame.setTextArea("Search results Characters:");
                for (Entity entity : admin.getCharacters()) {
                    if (Compare.compare(entity.getName(), searchword)) {
                        charFound++;
                        mainFrame.setTextArea("-" + entity.toString());
                    }
                }
                if (charFound == 0) {
                    mainFrame.setTextArea("No character found.");
                }
                mainFrame.setTextArea("Search results Locations:");
                for (Entity entity : admin.getLocations()) {
                    if (Compare.compare(entity.getName(), searchword)) {
                        locFound++;
                        mainFrame.setTextArea("-" + entity.toString());
                    }
                }
                if (locFound == 0) {
                    mainFrame.setTextArea("No location found.");
                }
                if (charFound == 0 && locFound == 0) {
                    mainFrame.setTextArea("Search results Entries:");
                    for (Entry entry : admin.getEntries()) {
                        if (Compare.compare(entry.toString(), searchword)) {
                            elseFound++;
                            mainFrame.setTextArea(entry.toString());
                        }
                    }
                    if (elseFound == 0) {
                        mainFrame.setTextArea("No entry found.");
                    }
                }
                searchFrame.frame.dispose();
            });
        }
        if (e.getSource() == mainFrame.getButtonStern()) {
            SaveManager.saveAdmin(admin, "admin.dat");
            for (Entity entity : admin.getCharacters()) {
                if (entity.getFav()) {
                    mainFrame.setTextArea("-" + entity.toString());
                }
            }
            for (Entity entity : admin.getLocations()) {
                if (entity.getFav()) {
                    mainFrame.setTextArea("-" + entity.toString());
                }
            }
        }
        if (e.getSource() == mainFrame.getButtonTag()) {
            sessionDayFrame = new SessionDayFrame();
            sessionDayFrame.buttonDay.addActionListener(ev -> {
                admin.setDay(admin.getDay() + 1);
                mainFrame.setTextArea("A new day has started.");
                SaveManager.saveAdmin(admin, "admin.dat");
                sessionDayFrame.frame.dispose();
            });
            sessionDayFrame.buttonSession.addActionListener(ev -> {
                admin.newSession();
                mainFrame.setTextArea("A new session has started.");
                SaveManager.saveAdmin(admin, "admin.dat");
                sessionDayFrame.frame.dispose();
            });
        }
        if (e.getSource() == mainFrame.getTextField()) {
            String input = mainFrame.getTextField().getText().trim();
            if (!input.isEmpty()) {
                boolean valid = false;
                mainFrame.setTextArea(input);
                mainFrame.getTextField().setText("");
                Entry entry = new Entry(input, admin.getDay(), admin.getSession());
                String[] words = input.toLowerCase().trim().split("\\s+");
                for (String word : words) {
                    for (int i = 0; i < admin.getCharacters().size(); i++) {
                        if (Compare.compare(admin.getCharacters().get(i).getName(), word)) {
                            admin.getCharacters().get(i).addEntry(entry);
                            setLast(admin.getCharacters().get(i).getName());    //hier auch der test
                            valid = true;
                            break;
                        }
                    }
                    for (int i = 0; i < admin.getLocations().size(); i++) {
                        if (Compare.compare(admin.getLocations().get(i).getName(), word)) {
                            admin.getLocations().get(i).addEntry(entry);
                        }
                    }
                    for (String pronoun : admin.getPronouns()) {
                        if (word.equals(pronoun) && !valid) {
                            for (int i = 0; i < admin.getCharacters().size(); i++) {
                                if (admin.getCharacters().get(i).getLast()) {
                                    admin.getCharacters().get(i).addEntry(entry);
                                    valid = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                admin.addEntry(entry);
            }
        }
    }
}
