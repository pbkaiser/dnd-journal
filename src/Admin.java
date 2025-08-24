import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {
    private int day;
    private int session;
    private String[] pronouns;
    private ArrayList<Entry> entries;
    private ArrayList<Entity> characters;
    private ArrayList<Entity> locations;
    public Admin() {
        pronouns = new String[] {
                "er", "ihn", "ihm", "seiner",
                "sein", "seine", "seines", "seinem", "seinen",
                "sie", "ihr", "ihrer",
                "ihre", "ihres", "ihrem", "ihren",
                "es",
                "sie", "ihnen", "ihrer",
                "ihr", "ihre", "ihres", "ihrem", "ihren",
                "he", "him", "his",
                "she", "her", "hers",
                "it", "its",
                "they", "them", "their", "theirs"
        };

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
    public String[] getPronouns() {
        return pronouns;
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
