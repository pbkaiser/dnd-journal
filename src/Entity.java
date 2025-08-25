import java.io.Serializable;
import java.util.ArrayList;

public class Entity implements Serializable {
    private String name;
    private ArrayList<Entry> entries;
    private boolean fav;
    private boolean last;

    Entity(String name) {
        this.name = name;
        entries = new ArrayList<>();
        fav = false;
        last = false;
    }
    public boolean getLast() {return last;}
    public void setLast(boolean last) {this.last = last;}
    public boolean getFav() {
        if(name.equals("Player")) {
            return false;
        }
        return fav;
    }
    public void setFav(boolean fav) {
        this.fav = fav;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }
    public void removeEntry(Entry entry) {}
    public int getUsages() {
        return entries.size();
    }
    public String getName() {
        return name;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    @Override
    public String toString() {
        String text = name;
        for (Entry entry : entries) {
            text = text + "\n"+ entry.toString();
        }
        return text;
    }
}
