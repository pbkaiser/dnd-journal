import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {
    private int day;
    private int session;
    private String[] pronouns;
    private String[] pronouns2;
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
        pronouns2 = new String[] {
                "ich", "mir", "meinem", "meinen", "meine", "wir", "uns", "unser", "unserem", "unseren", "unsere", "unseres",
                "I", "me", "my", "mine",
                "we", "us", "our", "ours"
        };

        entries = new ArrayList<>();
        characters = new ArrayList<>();
        locations = new ArrayList<>();
        day = 1;
        session = 0;
        this.addCharacter(new Entity("Player"));
        this.getCharacters().get(0).setFav(true);
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
    public String[] getPronouns2() {
        return pronouns2;
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
