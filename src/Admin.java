import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {
    private int day;
    private int session;
    private ArrayList<Entry> entries;
    private ArrayList<Entity> characters;
    private ArrayList<Entity> locations;
    public Admin() {
        entries = new ArrayList<>();
        characters = new ArrayList<>();
        locations = new ArrayList<>();
        day = 1;
        session = 0;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void newSession() {
        session++;
    }
    public int getDay() {
        return day;
    }
    public int getSession() {
        return session;
    }
    public ArrayList<Entry> getEntries() {
        return entries;
    }
    public ArrayList<Entity> getCharacters() {
        return characters;
    }
    public ArrayList<Entity> getLocations() {
        return locations;
    }
    public void addEntry(Entry entry) {
        entries.add(entry);
    }
    public void addCharacter(Entity character) {
        characters.add(character);
    }
    public void addLocation(Entity location) {
        locations.add(location);
    }
    }
